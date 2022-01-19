package com.produtos.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.produtos.apirest."))
	.paths(regex("/api.*"))
	.build()
	.apiInfo(metaInfo());
	}
	private ApiInfo metaInfo() {
		return null;
	}
	private Predicate<String> regex(String string) {
		return null;
	}
	private ApiInfo metaiInfo()
	{ ApiInfo apiInfo = new ApiInfo(  

	"Spring Boot REST API",
	"Spring Boot REST API",
	"1.0",
	"Apache License Version 2.0",
       new Contact("https://www.apache.org/licenses/LICENSE-2.0\""), new ArrayList<VendorExtension>()
	);
	
	return apiInfo;
	
	}
	
}
	