package com.mamahao.microservice.app.api.controller;

import com.mamahao.microservice.app.api.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/2
 * Time           :   10:12
 * Description    :
 */
@RestController
//@RefreshScope
public class UseConfigController {
	@Value("${env}")
	String env;
	@Value(("${user.name}"))
	String username;

	@RequestMapping(value = "/v1/config")
	public String users(){
		System.out.println("env=="+env);
		System.out.println("username=="+username);
		return "env="+env+",username="+username;
	}
}
