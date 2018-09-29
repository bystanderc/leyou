package com.leyou.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author bystander
 * @date 2018/9/29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyUserApplication.class);
    }
}
