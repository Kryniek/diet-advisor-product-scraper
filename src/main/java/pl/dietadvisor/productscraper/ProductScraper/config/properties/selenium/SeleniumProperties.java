package pl.dietadvisor.productscraper.ProductScraper.config.properties.selenium;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("product-scraper.selenium")
@Data
public class SeleniumProperties {
    private String host;
}
