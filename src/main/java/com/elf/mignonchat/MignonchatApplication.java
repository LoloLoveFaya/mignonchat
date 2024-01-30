package com.elf.mignonchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.elf.mignonchat")
public class MignonchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MignonchatApplication.class, args);
	}

}
