package com.mamahao.microservice.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   16:56
 * Description    :
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class,args);
	}
}
