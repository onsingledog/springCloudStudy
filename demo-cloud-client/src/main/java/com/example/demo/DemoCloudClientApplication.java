package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * client子模块
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class DemoCloudClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCloudClientApplication.class, args);
	}

	@Value("${server.port}")
	private String port;

	@RequestMapping("/hi")
	public String test(String name){

		return "hi "+name+",i am from port:" +port;
	}

}
