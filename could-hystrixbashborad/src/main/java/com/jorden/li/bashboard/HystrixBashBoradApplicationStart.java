package com.jorden.li.bashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixBashBoradApplicationStart {

    public static  void main(String [] args){
    	SpringApplication.run(HystrixBashBoradApplicationStart.class, args);
    }
}