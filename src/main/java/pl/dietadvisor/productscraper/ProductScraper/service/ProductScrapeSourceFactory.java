package pl.dietadvisor.productscraper.ProductScraper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dietadvisor.productscraper.ProductScraper.definition.productScrapeSource.ProductScrapeSource;
import pl.dietadvisor.productscraper.ProductScraper.enums.ProductScrapeJobSource;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductScrapeSourceFactory {
    private final List<ProductScrapeSource> scrapeSources;

    public ProductScrapeSource getSource(ProductScrapeJobSource productScrapeJobSource) {
        return scrapeSources.stream()
                .filter(scrapeSource -> scrapeSource.getSource().equals(productScrapeJobSource))
                .findFirst()
                .orElseThrow();
    }
}
