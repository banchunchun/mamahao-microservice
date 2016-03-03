package com.mamahao.microservice.user.manager.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/3
 * Time           :   13:46
 * Description    :
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {

}
