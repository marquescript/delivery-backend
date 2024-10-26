package com.delivery.api;

import com.delivery.api.infra.config.DotenvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliveryApplication {


	public static void main(String[] args) {
		DotenvConfig.loadEnv();
		SpringApplication.run(DeliveryApplication.class, args);
	}

}
