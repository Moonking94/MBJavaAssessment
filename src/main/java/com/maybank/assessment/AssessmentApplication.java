package com.maybank.assessment;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableFeignClients
public class AssessmentApplication {

	@PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kuala_Lumpur"));
    }
	
	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

}
