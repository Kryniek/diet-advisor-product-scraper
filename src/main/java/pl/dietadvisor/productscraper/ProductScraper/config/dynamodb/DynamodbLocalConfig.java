package pl.dietadvisor.productscraper.ProductScraper.config.dynamodb;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import lombok.RequiredArgsConstructor;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.dietadvisor.productscraper.ProductScraper.config.properties.aws.AwsProperties;

@Configuration
@EnableDynamoDBRepositories(basePackages = "pl.dietadvisor.productscraper.ProductScraper.repository")
@RequiredArgsConstructor
@Profile("dev")
public class DynamodbLocalConfig {
    private final AwsProperties awsProperties;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsProperties.getUrl(), awsProperties.getRegion()))
                .build();
    }
}
