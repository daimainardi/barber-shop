package com.daimainardi.barbershop.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Barber Shop API")
                        .description("Barber Shop application, responsible for the CRUD of barbers, customers and barbershop services")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Developer Daiane Mainardi")
                                .email("daimainardi@gmail.com")));
    }
}
