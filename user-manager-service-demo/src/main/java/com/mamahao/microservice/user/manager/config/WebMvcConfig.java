package com.mamahao.microservice.user.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/3
 * Time           :   11:59
 * Description    :
 */
@Configuration
public class WebMvcConfig  extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
}
