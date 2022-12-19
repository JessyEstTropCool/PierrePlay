package be.helb.PierrePlay.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SpringFoxConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver defaultViewResolver(){
        return new InternalResourceViewResolver();
    }

    /*@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
        //registry.addMapping("/").allowedOrigins("http://localhost:4200");
        // registry.addMapping("/users/{id}").allowedOrigins("http://localhost:4200");
    }*/

    private ApiInfo apiInfo()
    {
        return new ApiInfo(
                "PierrePlay",
                "PierrePlay is a game library where you categorise and leave reviews about your favorite games",
                "1.0",
                "Terms of service",
                new Contact("Jessy Adam", "jadam.alwaysdata.net", "jadam.jessyadam@gmail.com"),
                "License of API",
                "There is no license, go wild",
                Collections.emptyList()
        );
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey(){
        return new ApiKey("JWT", "Authorization", "header");
    }
}
