package com.example.school;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class SchoolServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolServiceApplication.class, args);
    }

}
