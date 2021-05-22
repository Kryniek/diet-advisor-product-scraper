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
mvn spring-boot:run "-Dspring-boot.run.arguments=--diet-advisor.aws.user-credentials.access-key=<YOUR_ACCESS_KEY> --diet-advisor.aws.user-credentials.secret-key=<YOUR_SECRET_KEY> --spring.profiles.active=prod"
```