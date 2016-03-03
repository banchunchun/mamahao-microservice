package com.mamahao.microservice.app.api.controller;

import com.mamahao.microservice.app.api.model.User;
import com.mamahao.microservice.app.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   16:58
 * Description    :
 */
@RestController
public class RestTemplateController extends BaseController{
	@Autowired
	UserService userService;

	@Value(("${user.name}"))
	String username;
	@RequestMapping(value = "/rt/users")
	public List<User> users(){
		System.out.println("username="+username);
		List<User> users = userService.findAll();
		return users;
	}
}
