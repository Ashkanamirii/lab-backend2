package se.nackademin.java20.lab1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

/**
 * Created by Ashkan Amiri
 * Date:  2021-08-30
 * Time:  19:27
 * Project: lab1-master
 * Copyright: MIT
 */
@Configuration
@EnableSwagger2
//@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
//validators.configuration.BeanValidatorPluginsConfiguration.class
//http://localhost:8089/swagger-ui.html
public class SwaggerConfig {

	@Bean
	public Docket swaggerSpringfoxDocket(){
		System.out.println("*********************************");

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				//.apiInfo(apiInfo())
				.pathMapping("/")
				.forCodeGeneration(true)
				.genericModelSubstitutes(ResponseEntity.class)
				.ignoredParameterTypes(java.sql.Date.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class)
				.useDefaultResponseMessages(false);
		docket = docket.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				//.paths(regex(DEFAULT_INCLUDE_PATTERN))
				.build();

		return docket;
	}

	/**
	 * change swagger config first page
	 *
	 * @return
	 */
/*	private springfox.documentation.service.ApiInfo apiInfo() {
		String message1 = "Hello Ashkan";

		ApiInfo apiInfo = new ApiInfo(message1,"","",
				"", "Samim",
				"", "dev");
		return apiInfo;
	}*/

}
