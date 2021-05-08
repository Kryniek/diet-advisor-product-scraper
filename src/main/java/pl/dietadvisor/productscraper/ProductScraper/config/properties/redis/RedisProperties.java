package pl.dietadvisor.productscraper.ProductScraper.config.properties.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("product-scraper.redis")
@Data
public class RedisProperties {
    private CacheProperties cache;
}
