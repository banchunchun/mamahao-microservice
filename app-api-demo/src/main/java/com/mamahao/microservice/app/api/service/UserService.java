package com.mamahao.microservice.app.api.service;

import com.mamahao.microservice.app.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   17:02
 * Description    :
 */
@Service
public class UserService {
	@Autowired
	RestTemplate restTemplate;
	final String USER_MANAGER_SERVER="user-manager-service-demo";

	public List<User> findAll(){
		List<User> users = restTemplate.getForObject("http://" + USER_MANAGER_SERVER + "/users",List.class);
		return users;
	}
}
