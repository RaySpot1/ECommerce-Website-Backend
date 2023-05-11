package com.myProject.ECommerceApp.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.DescriptionResolver;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Profile("prod")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public DescriptionResolver descriptionResolver(Environment environment) {
        return new DescriptionResolver(environment);
    }
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.myProject.ECommerceApp.Controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact("webtutsplus", "http://webtutsplus.com", "contact.webtutsplus@gmail,com");
        return new ApiInfoBuilder()
                .title("ECommerceApp API")
                .description("Documentation ECommerce api")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }
}
