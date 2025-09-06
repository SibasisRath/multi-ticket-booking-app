package com.remock.commons.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Common Swagger/OpenAPI configuration for all Remock microservices
 */
@Configuration
@ConditionalOnClass(OpenAPI.class)
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Remock Microservice API")
                        .version("1.0.0")
                        .description("API documentation for Remock microservices")
                        .contact(new Contact()
                                .name("Remock Team")
                                .email("support@remock.com")
                                .url("https://remock.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
