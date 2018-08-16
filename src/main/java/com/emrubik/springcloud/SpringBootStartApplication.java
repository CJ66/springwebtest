package com.emrubik.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootStartApplication extends SpringBootServletInitializer{
    
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootStartApplication.class);
    }
	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootStartApplication.class).web(true).run(args);
	}

}
