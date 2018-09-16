package com.leyou.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author bystander
 * @date 2018/9/16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LyUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyUploadApplication.class);
    }
}
