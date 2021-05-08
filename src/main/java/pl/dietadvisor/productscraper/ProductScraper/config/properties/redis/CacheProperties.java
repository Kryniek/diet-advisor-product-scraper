package pl.dietadvisor.productscraper.ProductScraper.config.properties.redis;

import lombok.Data;

@Data
public class CacheProperties {
    private String ttlSeconds;
}
