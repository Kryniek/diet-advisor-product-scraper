package pl.dietadvisor.productscraper.ProductScraper.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dietadvisor.productscraper.ProductScraper.model.Product;

import java.util.List;

@Repository
@EnableScan
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findByNameIn(List<String> names);
}
