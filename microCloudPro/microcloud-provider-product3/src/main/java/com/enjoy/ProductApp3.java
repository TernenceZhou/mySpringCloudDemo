package com.enjoy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = "com.enjoy.mapper")
@EnableEurekaClient
@EnableDiscoveryClient //启用发现服务项
public class ProductApp3 {

    public static void main(String[] args) {

        SpringApplication.run(ProductApp3.class,args);
    }
}
