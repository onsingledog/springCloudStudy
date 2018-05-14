package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * feign负载均衡，断路器工程
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DemoFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFeignApplication.class, args);
	}
}
