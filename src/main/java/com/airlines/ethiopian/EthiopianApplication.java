package com.airlines.ethiopian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.xpo.booking",
		"com.airlines.ethiopian",
		"common.shared.utility"
})public class EthiopianApplication {

	public static void main(String[] args) {
		SpringApplication.run(EthiopianApplication.class, args);
	}

}
