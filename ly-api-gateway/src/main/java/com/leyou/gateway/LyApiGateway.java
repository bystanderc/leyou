package com.leyou.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author bystander
 * @date 2018/9/13
 */
@SpringCloudApplication
@EnableZuulProxy
public class LyApiGateway {

    public static void main(String[] args) {
        SpringApplication.run(LyApiGateway.class);
    }
}
