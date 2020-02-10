/* 
User: Urmi
Date: 2/10/2020 
Time: 4:09 PM
*/

package com.example.first.spring.FirstSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).
                select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    private ApiInfo metaData(){
        Contact contact = new Contact("Urmi Mukhopadhyay", "https://mukhou", "banerjeeurmi@gmail.com");
        return new ApiInfo(
                "Spring Pet Clinic App",
                "Spring Pet Clinic App",
                "1.0",
                "http.//dummy",
                contact,
                "l1",
                "http://dummy",
                new ArrayList<>());

    }

}
