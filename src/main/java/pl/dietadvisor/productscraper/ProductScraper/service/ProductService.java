package pl.dietadvisor.productscraper.ProductScraper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dietadvisor.productscraper.ProductScraper.model.Product;
import pl.dietadvisor.productscraper.ProductScraper.repository.ProductRepository;

import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.isNotBlank;
import static pl.dietadvisor.productscraper.ProductScraper.enums.ProductSource.USER;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> get() {
        return (List<Product>) repository.findAll();
    }

    public Product getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Product create(Product product) {
        product.setId(null);
        product.setCreatedAt(now());

        return repository.save(product);
    }

    public List<Product> createAll(List<Product> products) {
        products.forEach(product -> {
            product.setId(null);
            product.setCreatedAt(now());
        });

        return (List<Product>) repository.saveAll(products);
    }

    public Product update(Product product) {
        Product existingProduct = getById(product.getId());
        if (isNotBlank(product.getName())) {
            existingProduct.setName(product.getName());
        }
        if (nonNull(product.getKcal())) {
            existingProduct.setKcal(product.getKcal());
        }
        if (nonNull(product.getProteins())) {
            existingProduct.setProteins(product.getProteins());
        }
        if (nonNull(product.getCarbohydrates())) {
            existingProduct.setCarbohydrates(product.getCarbohydrates());
        }
        if (nonNull(product.getFats())) {
            existingProduct.setFats(product.getFats());
        }
        existingProduct.setUpdatedAt(now());
        existingProduct.setSource(USER);

        return repository.save(existingProduct);
    }

    public List<Product> getByNames(List<String> names) {
        return repository.findByNameIn(names);
    }
}
