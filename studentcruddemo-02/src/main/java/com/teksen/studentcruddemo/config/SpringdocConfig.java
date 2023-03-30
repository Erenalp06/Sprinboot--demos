package com.teksen.studentcruddemo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SpringdocConfig {

    @Bean
    public OpenAPI studentOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("Student Management Project")
                        .description("This project is only for learning open api")
                        .termsOfService("runcodenow")
                        .contact(new Contact().name("Erenalp Tekşen").email("erenalpteksen01@gmail.com"))
                        .license(new License().name("Student OpenAPI License").url("runcodenow"))
        );
    }
}
