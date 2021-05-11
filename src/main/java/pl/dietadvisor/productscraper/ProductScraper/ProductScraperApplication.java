package pl.dietadvisor.productscraper.ProductScraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.dietadvisor.Common.productScraper.config.ProductScraper;

@SpringBootApplication
@ProductScraper
public class ProductScraperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductScraperApplication.class, args);
    }

}
