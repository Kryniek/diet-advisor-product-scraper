package pl.dietadvisor.productscraper.ProductScraper.repository.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dietadvisor.productscraper.ProductScraper.model.redis.ProductScrapeJobCancel;

@Repository
public interface ProductScrapeJobCancelRedisRepository extends CrudRepository<ProductScrapeJobCancel, String> {
}
