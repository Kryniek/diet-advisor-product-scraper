package pl.dietadvisor.productscraper.ProductScraper.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dietadvisor.productscraper.ProductScraper.exception.custom.BadRequestException;
import pl.dietadvisor.productscraper.ProductScraper.model.Product;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductMigration;
import pl.dietadvisor.productscraper.ProductScraper.service.ProductMigrationService;

import javax.validation.constraints.NotBlank;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.util.CollectionUtils.isEmpty;

@RestController
@RequiredArgsConstructor
@RequestMapping("products/migrations")
public class ProductMigrationController {
    private final ProductMigrationService service;

    @GetMapping("{jobId}")
    public ResponseEntity<ProductMigration> getById(@PathVariable @NotBlank String jobId) {
        return ResponseEntity.ok(service.getById(jobId));
    }

    @PostMapping
    public ResponseEntity<List<Product>> migrate(@RequestBody @NonNull ProductMigration productMigration) {
        validateMigrationRequestData(productMigration);

        return new ResponseEntity<>(service.migrate(productMigration), CREATED);
    }

    private void validateMigrationRequestData(@RequestBody @NonNull ProductMigration productMigration) {
        requireNonNull(productMigration.getJob(), "Job must be set.");
        requireNonNull(productMigration.getJob().getId(), "Job id must be set.");

        if (!productMigration.isSaveAll()) {
            requireNonNull(productMigration.getMigrationLogsIds(), "Migration logs ids must be set.");
            if (isEmpty(productMigration.getMigrationLogsIds())) {
                throw new BadRequestException("Migration logs ids must be not empty.");
            }
            boolean isAnyIdBlank = productMigration.getMigrationLogsIds()
                    .stream()
                    .anyMatch(String::isBlank);
            if (isAnyIdBlank) {
                throw new BadRequestException("Migration logs ids must be not blank.");
            }
        }
    }
}
