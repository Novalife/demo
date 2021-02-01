package com.daixy.lock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author daixiaoyong
 * @date 2019/11/18 15:32
 */

@SpringBootApplication
@EnableEurekaClient
public class LockApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockApplication.class, args);
    }
}