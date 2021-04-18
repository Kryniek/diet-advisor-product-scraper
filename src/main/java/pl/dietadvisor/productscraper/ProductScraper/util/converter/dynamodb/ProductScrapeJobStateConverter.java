package pl.dietadvisor.productscraper.ProductScraper.util.converter.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import pl.dietadvisor.productscraper.ProductScraper.enums.ProductScrapeJobState;

public class ProductScrapeJobStateConverter implements DynamoDBTypeConverter<String, ProductScrapeJobState> {
    @Override
    public String convert(ProductScrapeJobState state) {
        return state.name();
    }

    @Override
    public ProductScrapeJobState unconvert(String rawState) {
        return ProductScrapeJobState.parse(rawState);
    }
}
