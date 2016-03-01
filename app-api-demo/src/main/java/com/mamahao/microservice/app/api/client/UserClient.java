package com.mamahao.microservice.app.api.client;

import com.mamahao.microservice.app.api.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   19:00
 * Description    :
 */
@FeignClient("user-manager-service-demo")
public interface UserClient {
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	List<User> findAll();
}
