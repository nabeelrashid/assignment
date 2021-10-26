package com.techvista.assignment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.tiss.eti.api.controller"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.useDefaultResponseMessages(false)
				.apiInfo(metadata());
	}
	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration(null, null, null, null, "Bearer 'Place token here' ", ApiKeyVehicle.HEADER, "Authorization", ",");
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder().title("External Threat Intelligence Platform.").description("\"External-TI Application Programming Interfaces\"")
				.version("1.0.0").build();
	}
}
