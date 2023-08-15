package com.lucifer.lab.config;



import java.util.*;
import springfox.documentation.spi.service.contexts.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	
	private ApiKey apiKeys() {
		
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}
	
	private List<SecurityContext> securityContexts(){
		return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	}
	
	private List<SecurityReference> sf(){
		AuthorizationScope scope = new AuthorizationScope("Global", "AccessEverything");
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scope}));
	}
	
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();		
	}
	
	
	
	private ApiInfo getInfo(){
		return new ApiInfo("Bloging Application: Back-End", "Developed By Waseem Khan", "1.0", "Terms of Services",
				new Contact("Waseem", "https://waseem.com", "mdvaseem014@gmail.com"), 
				"License of APIs", "API License URL",new ArrayList<>());
	};

}
	