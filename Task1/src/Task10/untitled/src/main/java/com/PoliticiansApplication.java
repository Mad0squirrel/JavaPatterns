package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class PoliticiansApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PoliticiansApplication.class, args);
        ApplicationContext ac = new ClassPathXmlApplicationContext("politicians.xml");
        Politicians p = (Politicians) ac.getBean("merkel"); //trump biden merkel
        System.out.println(p.doPolitics());
    }

}
