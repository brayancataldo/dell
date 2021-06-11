package com.residencia.dell.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {
/*
	@Bean
	public Docket api(){
		Predicate<RequestHandler>basePackage = RequestHandlerSelectors.basePackage("com.residencia.dell*");
		Predicate<String>apiUrls = PathSelectors.ant("/api/**");
		return new Docket(DocumentationType.SWAGGER_2).select().apis(basePackage).paths(apiUrls).build();
	}
*/
}
