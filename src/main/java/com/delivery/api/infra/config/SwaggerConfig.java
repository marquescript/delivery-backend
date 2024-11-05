package com.delivery.api.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo());
                //.servers(Collections.singletonList(new Server().url("/api-delivery")));
    }

    private Info apiInfo() {
        return new Info()
                .title("Delivery API Doc")
                .version("1.0.0");
    }

}
