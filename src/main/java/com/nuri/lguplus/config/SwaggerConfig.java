package com.nuri.lguplus.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
 
    @Bean
    public Docket api() {
    	List<ResponseMessage> ar = new ArrayList<ResponseMessage>();
    	
    	ResponseMessageBuilder rmb = new ResponseMessageBuilder();
    	rmb.code(500);
    	rmb.message("Internal Server Error");
    	rmb.responseModel(new ModelRef("Error"));
    	ar.add(rmb.build());
    	
    	rmb = new ResponseMessageBuilder();
    	rmb.code(400);
    	rmb.message("Bad Request");
    	ar.add(rmb.build());
    	
    	rmb = new ResponseMessageBuilder();
    	rmb.code(404);
    	rmb.message("Not Found");
    	ar.add(rmb.build());
    	
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nuri.lguplus.mvc.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, ar);
    }
 
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger2")
                .description("swagger2")
                .build();
 
    }
}
