package pl.coderslab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.web.BookController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")

public class AppConfig implements WebMvcConfigurer {

}
