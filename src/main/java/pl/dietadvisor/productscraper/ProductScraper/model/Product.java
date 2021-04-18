package pl.dietadvisor.productscraper.ProductScraper.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dietadvisor.productscraper.ProductScraper.util.converter.dynamodb.LocalDateTimeConverter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "products")
public class Product {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;
    private String name;
    private Integer kcal;
    private BigDecimal proteins;
    private BigDecimal carbohydrates;
    private BigDecimal fats;
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime createdAt;
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime updatedAt;
}