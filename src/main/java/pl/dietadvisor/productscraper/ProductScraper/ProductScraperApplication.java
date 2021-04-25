package pl.dietadvisor.productscraper.ProductScraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ProductScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductScraperApplication.class, args);
	}

}
