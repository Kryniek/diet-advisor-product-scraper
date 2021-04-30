package pl.dietadvisor.productscraper.ProductScraper.util.converter.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import lombok.NonNull;
import pl.dietadvisor.productscraper.ProductScraper.enums.ProductScrapeJobState;

import javax.validation.constraints.NotBlank;

public class ProductScrapeJobStateConverter implements DynamoDBTypeConverter<String, ProductScrapeJobState> {
    @Override
    public String convert(@NonNull ProductScrapeJobState state) {
        return state.name();
    }

    @Override
    public ProductScrapeJobState unconvert(@NotBlank String rawState) {
        return ProductScrapeJobState.parse(rawState);
    }
}
