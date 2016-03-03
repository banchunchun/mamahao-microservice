package com.mamahao.microservice.user.manager.service;

import com.mamahao.microservice.user.manager.mapper.UserMapper;
import com.mamahao.microservice.user.manager.model.BaseEntity;
import com.mamahao.microservice.user.manager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/3
 * Time           :   11:28
 * Description    :
 */
@Service
public class UserService extends BaseEntity{
	@Autowired
	private UserMapper userMapper;


	public User save(User user){
		int i = 0;
		if(user.getId() != null){
			userMapper.updateByPrimaryKey(user);
		}else {
			userMapper.insertUseGeneratedKeys(user);
		}
		return user;
	}

	public List<User> getAll(){
		return userMapper.selectAll();
	}
}
