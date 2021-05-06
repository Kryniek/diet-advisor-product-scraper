package pl.dietadvisor.productscraper.ProductScraper.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.dietadvisor.productscraper.ProductScraper.definition.productScrapeSource.ProductScrapeSource;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeJob;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeLog;
import pl.dietadvisor.productscraper.ProductScraper.service.ProductScrapeJobService;
import pl.dietadvisor.productscraper.ProductScraper.service.ProductScrapeLogService;
import pl.dietadvisor.productscraper.ProductScraper.service.ProductScrapeSourceFactory;
import pl.dietadvisor.productscraper.ProductScraper.util.aop.KafkaConsumerLog;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.util.CollectionUtils.isEmpty;
import static pl.dietadvisor.productscraper.ProductScraper.enums.ProductScrapeJobState.*;

@Component
@RequiredArgsConstructor
@Log4j2
public class ProductScrapeJobConsumer {
    private final ProductScrapeJobService productScrapeJobService;
    private final ProductScrapeLogService productScrapeLogService;
    private final ProductScrapeSourceFactory productScrapeSourceFactory;

    @KafkaConsumerLog
    @KafkaListener(topics = "${product-scraper.kafka.topic.products-scrape-job}",
            groupId = "${product-scraper.kafka.consumer.group-id}")
    public void listen(ProductScrapeJob productScrapeJob) {
        try {
            log.info("Started scraping product scrape job: {}", productScrapeJob.getId());
            productScrapeJob = productScrapeJobService.update(ProductScrapeJob.builder()
                    .id(productScrapeJob.getId())
                    .state(IN_PROGRESS)
                    .build());
            List<ProductScrapeLog> scrapeLogs = getScrapeLogs(productScrapeJob);
            if (!isEmpty(scrapeLogs)) {
                productScrapeLogService.createAll(scrapeLogs);
            }

            productScrapeJob.setScrapedProductsNumber(scrapeLogs.size());
            productScrapeJobService.update(productScrapeJob);
        } catch (Exception exception) {
            log.error("Unexpected exception thrown when processing source: {}, product scrape job id: {}, message: {}",
                    productScrapeJob.getSource(),
                    productScrapeJob.getId(),
                    exception.getMessage());
            log.error(exception);

            productScrapeJob.setState(FAILED);
            productScrapeJob.setErrorMessage(exception.getMessage());
            productScrapeJobService.update(productScrapeJob);
        } finally {
            log.info("Finished scraping product scrape job: {}", productScrapeJob.getId());
        }
    }

    private List<ProductScrapeLog> getScrapeLogs(ProductScrapeJob productScrapeJob) {
        ProductScrapeSource scrapeSource = productScrapeSourceFactory.getSource(productScrapeJob.getSource());
        List<ProductScrapeLog> scrapeLogs = scrapeSource.scrape(productScrapeJob);

        if (FAILED.equals(productScrapeJob.getState()) || CANCELLED.equals(productScrapeJob.getState())) {
            if (isEmpty(scrapeLogs)) {
                return List.of();
            }

            productScrapeJob.setState(FINISHED_WITH_ERRORS);
        } else {
            productScrapeJob.setState(FINISHED);
        }

        return scrapeLogs
                .stream()
                .map(sl -> sl.toBuilder()
                        .jobId(productScrapeJob.getId())
                        .build())
                .collect(toList());
    }
}
