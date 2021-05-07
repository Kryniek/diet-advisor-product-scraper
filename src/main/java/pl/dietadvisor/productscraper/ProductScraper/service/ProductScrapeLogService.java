package pl.dietadvisor.productscraper.ProductScraper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeLog;
import pl.dietadvisor.productscraper.ProductScraper.repository.ProductScrapeLogRepository;

import java.util.List;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class ProductScrapeLogService {
    private final ProductScrapeLogRepository repository;

    public List<ProductScrapeLog> get() {
        return (List<ProductScrapeLog>) repository.findAll();
    }

    public ProductScrapeLog getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public List<ProductScrapeLog> getByIds(List<String> ids) {
        return repository.findByIdIn(ids);
    }

    public List<ProductScrapeLog> createAll(List<ProductScrapeLog> productScrapeLogs) {
        productScrapeLogs.forEach(productScrapeLog -> {
            productScrapeLog.setId(null);
            productScrapeLog.setCreatedAt(now());
        });

        return (List<ProductScrapeLog>) repository.saveAll(productScrapeLogs);
    }

    public List<ProductScrapeLog> getByJobId(String jobId) {
        return repository.findByJobId(jobId);
    }
}
