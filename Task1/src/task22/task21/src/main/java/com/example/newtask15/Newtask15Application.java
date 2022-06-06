package com.example.newtask15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Newtask15Application {
    //http://127.0.0.1:8080/manufactures/code/1
    public static void main(String[] args) {
        SpringApplication.run(Newtask15Application.class, args);
    }

}
