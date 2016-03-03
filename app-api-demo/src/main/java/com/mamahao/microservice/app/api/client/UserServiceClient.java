package com.mamahao.microservice.app.api.client;

import com.mamahao.microservice.app.api.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   19:00
 * Description    :
 */
@FeignClient("user-manager-service-demo")
public interface UserServiceClient {
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	List<User> findAllNoDao();


	@RequestMapping(value = "/mybatis/users",method = RequestMethod.GET)
	List<User> findAll();

	@RequestMapping(value = "/mybatis/save",method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	User save(@RequestBody User user);
}
