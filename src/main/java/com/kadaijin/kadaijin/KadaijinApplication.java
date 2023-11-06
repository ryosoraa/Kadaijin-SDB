package com.kadaijin.kadaijin;

import java.util.TimeZone;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Kadaijin", description = "Just Playground", version = "v1", license = @License(name = "Apache 2.0")))
public class KadaijinApplication {

	public static void main(String[] args) {
		SpringApplication.run(KadaijinApplication.class, args);
//		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Jakarta"));
	}

}
