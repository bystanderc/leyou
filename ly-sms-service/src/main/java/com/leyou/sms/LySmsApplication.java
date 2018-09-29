package com.leyou.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author bystander
 * @date 2018/9/29
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LySmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LySmsApplication.class);
    }
}
