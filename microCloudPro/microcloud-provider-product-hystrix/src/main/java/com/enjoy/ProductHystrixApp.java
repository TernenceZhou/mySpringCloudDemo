package com.enjoy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan(value = "com.enjoy.mapper")
@EnableEurekaClient
@EnableDiscoveryClient //启用发现服务项
@EnableCircuitBreaker //增加熔断注解
/**
 * 服务的熔断：熔断指的是当服务的提供方不可使用的时候，程序不会出现异常，而会出现本地的操作调用，
 * 服务的熔断是在服务消费方实现的，在断网情况下服务提供方的任何处理都是没有意义的。
 */
public class ProductHystrixApp {

    public static void main(String[] args) {

        SpringApplication.run(ProductHystrixApp.class,args);
    }
}
