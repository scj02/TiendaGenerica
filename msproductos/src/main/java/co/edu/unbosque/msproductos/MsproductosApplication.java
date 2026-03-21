package co.edu.unbosque.msproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

@SpringBootApplication
public class MsproductosApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MsproductosApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MsproductosApplication.class, args);
    }
}
