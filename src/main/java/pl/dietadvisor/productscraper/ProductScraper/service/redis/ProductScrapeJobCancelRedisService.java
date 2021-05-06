package pl.dietadvisor.productscraper.ProductScraper.service.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dietadvisor.productscraper.ProductScraper.model.redis.ProductScrapeJobCancel;
import pl.dietadvisor.productscraper.ProductScraper.repository.redis.ProductScrapeJobCancelRedisRepository;

@Service
@RequiredArgsConstructor
public class ProductScrapeJobCancelRedisService {
    private final ProductScrapeJobCancelRedisRepository repository;

    public ProductScrapeJobCancel cancel(String id) {
        return repository.save(ProductScrapeJobCancel.builder()
                .id(id)
                .build());
    }

    public boolean isCancelled(String id) {
        return repository.existsById(id);
    }
}
