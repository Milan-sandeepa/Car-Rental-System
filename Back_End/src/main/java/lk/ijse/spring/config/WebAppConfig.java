package lk.ijse.spring.config;

import lk.ijse.spring.advisor.AppWideExceptionHandler;
import lk.ijse.spring.controller.AdminController;
import lk.ijse.spring.controller.CarController;
import lk.ijse.spring.controller.LoginController;
import lk.ijse.spring.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {AppWideExceptionHandler.class, AdminController.class, UserController.class, LoginController.class, CarController.class})
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("/uploads/");
    }
}
