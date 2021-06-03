package com.app.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.app.order.ui.FrontEnd;



//@EnableSwagger2
@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(OrderApplication.class, args);
		ConfigurableApplicationContext context=SpringApplication.run(OrderApplication.class, args);
		FrontEnd frontend=context.getBean(FrontEnd.class);
		frontend.start();
	}

//	@Bean
//	public Docket api() {
//		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//				.apis(RequestHandlerSelectors.basePackage("com.app.order")).paths(PathSelectors.any()).build();
//		return docket;
//	}
//
//	@Bean
//	public ApiInfo apiInfo() {
//		ApiInfo info = new ApiInfoBuilder().title("Order service").description("rest api for Order service").build();
//		return info;
//	}
//
//	@Bean
//	public RestTemplate getRestTemplate() {
//		RestTemplate restTemplate = new RestTemplate();
//		return restTemplate;
//	}

}
