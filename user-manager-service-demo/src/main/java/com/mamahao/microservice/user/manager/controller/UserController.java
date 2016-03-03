package com.mamahao.microservice.user.manager.controller;

import com.mamahao.microservice.user.manager.model.User;
import com.mamahao.microservice.user.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   16:40
 * Description    :
 */
@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users")
	public List<User> users(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1L,"哈哈哈"));
		users.add(new User(2L,"嘿嘿嘿"));
		users.add(new User(3L,"呵呵呵"));
		return users;
	}


	@RequestMapping(value = "/mybatis/users")
	public List<User> findAll(){
		List<User> users = userService.getAll();
		return users;
	}

	@RequestMapping(value = "/mybatis/save")
	public ResponseEntity<User> save(@RequestBody User user){
		user = userService.save(user);
		return ResponseEntity.ok(user);
	}

}
