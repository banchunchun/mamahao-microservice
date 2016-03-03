package com.mamahao.microservice.user.manager.model;

import javax.persistence.*;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/3
 * Time           :   11:31
 * Description    :
 */
public class BaseEntity {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Transient
	private Integer page = 1;

	@Transient
	private Integer rows = 10;
}
