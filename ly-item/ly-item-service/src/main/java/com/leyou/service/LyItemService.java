package com.leyou.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author bystander
 * @date 2018/9/13
 */
@SpringBootApplication
@EnableEurekaClient
public class LyItemService {

    public static void main(String[] args) {
        SpringApplication.run(LyItemService.class);
    }
}
