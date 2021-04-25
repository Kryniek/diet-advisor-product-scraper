package pl.dietadvisor.productscraper.ProductScraper.config.properties.aws;

import lombok.Data;

@Data
public class UserCredentialsProperties {
    private String accessKey;
    private String secretKey;
}
