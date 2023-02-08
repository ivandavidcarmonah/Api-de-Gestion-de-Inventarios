package com.backend.project;

//import org.flywaydb.core.Flyway;
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
//		Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://127.0.0.1:3306/desa_daviddev", "root", "root").load();
		//flyway.migrate();
		SpringApplication.run(BackendStandarSpringBootApiRestApplication.class, args);
	}

}
