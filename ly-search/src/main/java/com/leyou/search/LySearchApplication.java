package com.leyou.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author bystander
 * @date 2018/9/22
 */
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class LySearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LySearchApplication.class);
    }
}
