package pl.dietadvisor.productscraper.ProductScraper.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dietadvisor.productscraper.ProductScraper.model.ProductScrapeJob;
import pl.dietadvisor.productscraper.ProductScraper.service.ProductScrapeJobService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products/scrape-jobs")
public class ProductScrapeJobController {
    private final ProductScrapeJobService service;

    @GetMapping
    public List<ProductScrapeJob> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public ProductScrapeJob getById(@PathVariable String id) {
        return service.getById(id);
    }
}
