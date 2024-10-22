package com.example.mable_assessment_martijn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MableAssessmentMartijnApplication {

	public static void main(String[] args) {
		SpringApplication.run(MableAssessmentMartijnApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
