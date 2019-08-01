package com.esamay;

import com.google.common.base.Predicates;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class ESamayApiSwaggerConfig {

    private static final String HEADER = "header";
    private static final String STRING = "string";

    private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Esamay APIs").description("Micro API ESamay REST Services").version("1.0")
				.build();
	}

	@Bean
	public Docket swaggerSettings() {
      List<Parameter> aParameters = new ArrayList<>();
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(this.apiInfo()).globalOperationParameters(aParameters)
				.select().paths(PathSelectors.any())
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.apis(RequestHandlerSelectors.basePackage("com.esamay"))
				.paths(Predicates.not(PathSelectors.regex("/error"))).build();

	}
}
