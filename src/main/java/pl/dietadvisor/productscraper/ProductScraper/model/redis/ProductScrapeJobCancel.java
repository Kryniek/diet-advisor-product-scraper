package pl.dietadvisor.productscraper.ProductScraper.model.redis;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("ProductScrapeJobCancel")
@Data
@Builder
public class ProductScrapeJobCancel {
    private String id;
}
