package pl.dietadvisor.productscraper.ProductScraper.definition.productScrapeSource;

import pl.dietadvisor.productscraper.ProductScraper.enums.ProductScrapeJobSource;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeJob;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeLog;

import java.util.List;

public interface ProductScrapeSource {
    ProductScrapeJobSource getSource();

    List<ProductScrapeLog> scrape(ProductScrapeJob productScrapeJob);
}
