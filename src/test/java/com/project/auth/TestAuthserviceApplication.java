package com.project.auth;

import org.springframework.boot.SpringApplication;

public class TestAuthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(AuthserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
