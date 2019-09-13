package com.pams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class PamsBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PamsBackendApiApplication.class, args);
	}

}
