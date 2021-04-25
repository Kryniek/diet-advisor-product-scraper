package pl.dietadvisor.productscraper.ProductScraper.config.properties.kafka;

import lombok.Data;

@Data
public class ConsumerProperties {
    private String groupId;
    private String autoOffsetReset;
}
