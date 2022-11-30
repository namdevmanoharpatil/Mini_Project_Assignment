package com.Soppify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SoppifyShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoppifyShopApplication.class, args);
		System.out.println("Mini Project Shoppify application server started...");
	}

}
