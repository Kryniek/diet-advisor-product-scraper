package pl.dietadvisor.productscraper.ProductScraper.config.annotations;

import org.springframework.context.annotation.Import;
import pl.dietadvisor.productscraper.ProductScraper.config.ApplicationConfig;

@Import(ApplicationConfig.class)
public @interface ProductScraper {
}
