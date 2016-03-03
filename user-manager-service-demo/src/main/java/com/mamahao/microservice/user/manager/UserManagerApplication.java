package com.mamahao.microservice.user.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   15:48
 * Description    :
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class UserManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserManagerApplication.class,args);
	}

}
