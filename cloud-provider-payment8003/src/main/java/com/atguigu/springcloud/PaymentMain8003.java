package com.atguigu.springcloud;import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cloud.client.discovery.EnableDiscoveryClient;import org.springframework.cloud.netflix.eureka.EnableEurekaClient;/** * @Author: 车子昂 * @Date: 2020-4-10 15:00 * @Description: *///主启动类@SpringBootApplication//eureka客户端@EnableEurekaClient//服务发现@EnableDiscoveryClientpublic class PaymentMain8003 {    public static void main(String[] args) {        SpringApplication.run(PaymentMain8003.class,args);    }}