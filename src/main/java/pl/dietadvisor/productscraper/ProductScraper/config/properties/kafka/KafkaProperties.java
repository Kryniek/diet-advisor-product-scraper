package pl.dietadvisor.productscraper.ProductScraper.config.properties.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("product-scraper.kafka")
@Data
public class KafkaProperties {
    private String bootstrapServers;
    private ClientProperties client;
    private ConsumerProperties consumer;
    private TopicProperties topic;
}
