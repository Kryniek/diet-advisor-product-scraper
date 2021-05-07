package pl.dietadvisor.productscraper.ProductScraper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductMigration;

@Service
@RequiredArgsConstructor
public class ProductMigrationService {
    private final ProductScrapeJobService productScrapeJobService;
    private final ProductScrapeLogService productScrapeLogService;

    public ProductMigration getById(String jobId) {
        return ProductMigration.builder()
                .job(productScrapeJobService.getById(jobId))
                .logs(productScrapeLogService.getByJobId(jobId))
                .build();
    }
}
