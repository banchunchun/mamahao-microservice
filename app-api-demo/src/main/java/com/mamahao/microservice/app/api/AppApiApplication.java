package com.mamahao.microservice.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   16:56
 * Description    :
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AppApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class,args);
	}
}
