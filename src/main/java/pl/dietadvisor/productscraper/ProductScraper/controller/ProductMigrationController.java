package pl.dietadvisor.productscraper.ProductScraper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductMigration;
import pl.dietadvisor.productscraper.ProductScraper.service.ProductMigrationService;

import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
@RequestMapping("products/migrations")
public class ProductMigrationController {
    private final ProductMigrationService service;

    @GetMapping("{jobId}")
    public ResponseEntity<ProductMigration> getById(@PathVariable @NotBlank String jobId) {
        return ResponseEntity.ok(service.getById(jobId));
    }
}
