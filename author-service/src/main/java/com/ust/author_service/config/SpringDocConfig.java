package com.ust.author_service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI authorOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("AuthorAPI")
                        .description("")
                        .version("v1.0")
                        .termsOfService("")
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("")
                        .url("http://springdoc.org"));
    }
}
