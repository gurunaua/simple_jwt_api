package com.example.jwt.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Login JWt API", version = "2.0", description = "User Role"))
public class DemoJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJwtApplication.class, args);
    }

}
