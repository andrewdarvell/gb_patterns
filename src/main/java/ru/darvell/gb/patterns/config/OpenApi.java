package ru.darvell.gb.patterns.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("Device info API")
                .version("1.0")
                .description("Сервис для работы с нодой с пулом устройств")
        );

    }
}
