package pl.dietadvisor.productscraper.ProductScraper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeJob;
import pl.dietadvisor.productscraper.ProductScraper.producer.ProductScrapeJobProducer;
import pl.dietadvisor.productscraper.ProductScraper.repository.ProductScrapeJobRepository;

import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isNotBlank;
import static pl.dietadvisor.productscraper.ProductScraper.enums.ProductScrapeJobState.CREATED;

@Service
@RequiredArgsConstructor
public class ProductScrapeJobService {
    private final ProductScrapeJobRepository repository;
    private final ProductScrapeJobProducer productScrapeJobProducer;

    public List<ProductScrapeJob> get() {
        return (List<ProductScrapeJob>) repository.findAll();
    }

    public ProductScrapeJob getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public ProductScrapeJob create(ProductScrapeJob requestProductScrapeJob) {
        ProductScrapeJob productScrapeJob = repository.save(ProductScrapeJob.builder()
                .state(CREATED)
                .source(requestProductScrapeJob.getSource())
                .createdAt(now())
                .build());
        productScrapeJobProducer.send(productScrapeJob);

        return productScrapeJob;
    }

    public ProductScrapeJob update(ProductScrapeJob productScrapeJob) {
        ProductScrapeJob existingProductScrapeJob = getById(productScrapeJob.getId());
        if (nonNull(productScrapeJob.getState())) {
            existingProductScrapeJob.setState(productScrapeJob.getState());
        }
        if (isNotBlank(productScrapeJob.getErrorMessage())) {
            existingProductScrapeJob.setErrorMessage(productScrapeJob.getErrorMessage());
        }
        if (nonNull(productScrapeJob.getScrapedProductsNumber())) {
            existingProductScrapeJob.setScrapedProductsNumber(productScrapeJob.getScrapedProductsNumber());
        }

        existingProductScrapeJob.setUpdatedAt(now());

        return repository.save(existingProductScrapeJob);
    }
}
