# Setup local environment
### Install dependencies
```
mvn clean install
```
### Run local environment
```
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=dev
```
### Run production environment
```
spring-boot:run "-Dspring-boot.run.arguments=--product-scraper.aws.user-credentials.access-key=<YOUR_ACCESS_KEY> --product-scraper.aws.user-credentials.secret-key=<YOUR_SECRET_KEY> --spring.profiles.active=prod"
```