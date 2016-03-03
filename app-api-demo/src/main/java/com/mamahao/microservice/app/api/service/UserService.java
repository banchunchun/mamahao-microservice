package com.mamahao.microservice.app.api.service;

import com.mamahao.microservice.app.api.client.UserServiceClient;
import com.mamahao.microservice.app.api.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   17:02
 * Description    :
 */
@Service
public class UserService {
	final String USER_MANAGER_SERVER="user-manager-service-demo";
	static final int randomNum = 100;

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private UserServiceClient userServiceClient;

	public List<User> findAll(){
		List<User> users = restTemplate.getForObject("http://" + USER_MANAGER_SERVER + "/users",List.class);
		return users;
	}

	@HystrixCommand(fallbackMethod = "emptyUserList")
	public List<User> list(){
		Random random = new Random();
		int i = random.nextInt(randomNum);
		System.out.println("i->"+i);
		int r = i % 10;
		System.out.println("r->"+r);
		if(r > 5){
			throw new RuntimeException();
		}
		return userServiceClient.findAll();
	}
	public User save(User user){
		return userServiceClient.save(user);
	}

	private List<User> emptyUserList(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1L,"服务不可用!"));
		users.add(new User(2L,"服务不可用!"));
		users.add(new User(3L,"服务不可用!"));
		return users;
	}
}
