package com.mamahao.microservice.app.api.controller;

import com.mamahao.microservice.app.api.client.UserClient;
import com.mamahao.microservice.app.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   18:59
 * Description    :
 */
@RestController
@RefreshScope
public class FeignController {
	@Autowired
	UserClient userClient;
	@Value("${env}")
	String env;
	@Value(("${user.name}"))
	String username;

	@RequestMapping(value = "/v2/users")
	public List<User> users(){
		System.out.printf("env=="+env);
		System.out.printf("username=="+username);
		List<User> users = userClient.findAll();
		return users;
	}
}
