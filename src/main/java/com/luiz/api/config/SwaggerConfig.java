package com.luiz.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.apiInfo());
	}
	
	private ApiInfo apiInfo() {
		 
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("API for working with People")
                .description ("How to manipulate personal data in a micro service.")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .termsOfServiceUrl("/service.html")
                .contact(new Contact("Luiz Henrique Oliveira de Souza","https://www.linkedin.com/in/luiz-henrique-oliveira-de-souza-b823a8127/", "luizhenriqque15@gmail.com"))
                .build();
 
        return apiInfo;
    }
}
