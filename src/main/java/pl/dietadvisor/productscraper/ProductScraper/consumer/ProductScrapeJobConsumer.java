package pl.dietadvisor.productscraper.ProductScraper.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeJob;
import pl.dietadvisor.productscraper.ProductScraper.util.aop.KafkaConsumerLog;

@Component
@Slf4j
public class ProductScrapeJobConsumer {
    @KafkaConsumerLog
    @KafkaListener(topics = "${product-scraper.kafka.topic.products-scrape-job}",
            groupId = "${product-scraper.kafka.consumer.group-id}")
    public void listen(ProductScrapeJob productScrapeJob) {
    }
}
