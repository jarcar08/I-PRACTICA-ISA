package com.example.demo;

import org.springframework.boot.SpringApplication;

public class TestSgEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.from(SgEmpleadosApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
