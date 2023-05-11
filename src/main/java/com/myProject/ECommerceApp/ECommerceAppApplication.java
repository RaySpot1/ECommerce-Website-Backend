package com.myProject.ECommerceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableJpaRepositories(basePackages = "com.myProject.ECommerceApp.repository")
@ComponentScan("com.myProject.ECommerceApp.*")
@SpringBootApplication
public class ECommerceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceAppApplication.class, args);
	}

}
