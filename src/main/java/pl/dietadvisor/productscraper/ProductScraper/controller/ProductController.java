package pl.dietadvisor.productscraper.ProductScraper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dietadvisor.productscraper.ProductScraper.model.Product;
import pl.dietadvisor.productscraper.ProductScraper.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<Product> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return service.getById(id);
    }

    @GetMapping("/test")
    public Product insert() {
        return service.create(Product.builder()
                .fats(new BigDecimal("1.1"))
                .carbohydrates(new BigDecimal("1.2"))
                .proteins(new BigDecimal("1.3"))
                .kcal(123)
                .name("Test")
                .build());
    }
}