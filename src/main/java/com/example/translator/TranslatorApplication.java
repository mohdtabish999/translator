package com.example.translator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
@EnableDiscoveryClient
public class TranslatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranslatorApplication.class, args);
	}
	
	@RefreshScope
	@RestController
	class MessageRestController {

	  @Value("${message:Config Server is not working. Please check...}")
	  private String message;

	  @RequestMapping("/message")
	  String getMessage() throws JsonMappingException, JsonProcessingException {
		  System.out.println(this.message);
	    return this.message;
	  }
	}

}
