package com.mamahao.microservice.app.api.controller;

import com.mamahao.microservice.app.api.client.UserServiceClient;
import com.mamahao.microservice.app.api.model.User;
import com.mamahao.microservice.app.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
	UserService userService;


	@RequestMapping(value = "/feign/users")
	public List<User> users(){
		List<User> users = userService.findAll();
		return users;
	}

	@RequestMapping(value = "/feign/user/list")
	public List<User> list(){
		List<User> users = userService.list();
		return users;
	}

	@RequestMapping(value = "/feign/user/save")
	public ResponseEntity<User> save(User user){
		user = userService.save(user);
		return ResponseEntity.ok(user);
	}
}
