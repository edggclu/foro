package com.alura.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("API Foro.alura")
                        .description("API Rest de la aplicación ForoAlura, que contiene las funcionalidades de CRUD de Topicos y Respuestas, así como programación y autenticacion de Usuarios.")
                        .contact(new Contact()
                                .name("Equipo Backend")
                                .email("backend@foro.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://com.alura/foro/licencia")));
    }

    @Bean
    public void message() {
        System.out.println("bearer is working");
    }
}
