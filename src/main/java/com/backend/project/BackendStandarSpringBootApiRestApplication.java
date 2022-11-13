package com.backend.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BackendStandarSpringBootApiRestApplication extends SpringBootServletInitializer {
	
	
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BackendStandarSpringBootApiRestApplication.class);
    }
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BackendStandarSpringBootApiRestApplication.class, args);
	}

}
