package com.delivery.api.infra.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DotenvConfig {

    public static void loadEnv(){
        Dotenv dotenv = Dotenv.configure().load();
        String dbUrl = dotenv.get("DB_URL");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
        String dbDriver = dotenv.get("DB_DRIVER");
        String googlePlacesKey = dotenv.get("GOOGLE_PLACES_KEY");

        System.setProperty("DB_URL", dbUrl);
        System.setProperty("DB_USERNAME", dbUsername);
        System.setProperty("DB_PASSWORD", dbPassword);
        System.setProperty("DB_DRIVER", dbDriver);
        System.setProperty("GOOGLE_PLACES_KEY", googlePlacesKey);
    }

}
