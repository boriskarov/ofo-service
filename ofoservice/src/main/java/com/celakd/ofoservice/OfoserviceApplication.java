package com.celakd.ofoservice;

import com.celakd.ofoservice.properties.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class OfoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfoserviceApplication.class, args);
	}

}
