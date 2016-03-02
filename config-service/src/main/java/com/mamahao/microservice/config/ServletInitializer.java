package com.mamahao.microservice.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/2
 * Time           :   16:51
 * Description    :
 */
public class ServletInitializer extends SpringBootServletInitializer {
	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConfigServiceApplication.class);
	}
}
