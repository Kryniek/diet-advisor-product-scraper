package pl.dietadvisor.productscraper.ProductScraper.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.dietadvisor.productscraper.ProductScraper.config.properties.kafka.KafkaProperties;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeJob;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductScrapeJobProducer {
    private final KafkaTemplate<String, Object> template;
    private final KafkaProperties kafkaProperties;

    public void send(ProductScrapeJob productScrapeJob) {
        template.send(kafkaProperties.getTopic().getProductsScrapeJob(), productScrapeJob);
    }
}
