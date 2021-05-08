package pl.dietadvisor.productscraper.ProductScraper.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
@EnableCaching
public class ApplicationConfig {
}
