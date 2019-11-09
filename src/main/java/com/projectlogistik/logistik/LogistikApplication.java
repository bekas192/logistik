package com.projectlogistik.logistik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaAuditing
public class LogistikApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogistikApplication.class, args);
	}
        
        @Bean
        public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/barang").allowedOrigins("http://localhost:4200");
         }
      };
   }
}
