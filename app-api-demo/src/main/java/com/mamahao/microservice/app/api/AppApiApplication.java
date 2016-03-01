package com.mamahao.microservice.app.api;

import com.mamahao.microservice.app.api.config.ConfigurationPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.util.*;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   16:56
 * Description    :
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
@EnableFeignClients
@EnableConfigurationProperties
@EnableHystrix
@EnableScheduling
public class AppApiApplication{
	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class,args);
	}

	@Autowired
	private ConfigurableApplicationContext context;
	@Autowired
	private ConfigurationPropertiesConfig configurationPropertiesConfig;
	@Autowired
	private RefreshScope scope;

	private Set<String> standardSources = new HashSet<String>(Arrays.asList(
			StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME,
			StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME,
			StandardServletEnvironment.JNDI_PROPERTY_SOURCE_NAME,
			StandardServletEnvironment.SERVLET_CONFIG_PROPERTY_SOURCE_NAME,
			StandardServletEnvironment.SERVLET_CONTEXT_PROPERTY_SOURCE_NAME));


	@Scheduled(cron="0/20 * *  * * ? ")   //每20秒执行一次
	public void refreshConfigProperties(){
		refresh();
		System.out.println(configurationPropertiesConfig.getEnv());
	}

	public void refresh() {
		Map<String, Object> before = extract(context.getEnvironment()
				.getPropertySources());
		addConfigFilesToEnvironment();
		Set<String> keys = changes(before,
				extract(context.getEnvironment().getPropertySources())).keySet();
		scope.refreshAll();

		context.publishEvent(new EnvironmentChangeEvent(keys));
	}

	@Configuration
	protected static class Empty {

	}

	private void addConfigFilesToEnvironment() {
		ConfigurableApplicationContext capture = null;
		try {
			capture = new SpringApplicationBuilder(Empty.class).showBanner(false)
					.web(false).environment(context.getEnvironment()).run();
			MutablePropertySources target = context.getEnvironment().getPropertySources();
			for (PropertySource<?> source : capture.getEnvironment().getPropertySources()) {
				String name = source.getName();
				if (!standardSources.contains(name)) {
					if (target.contains(name)) {
						target.replace(name, source);
					}
					else {
						if (target.contains("defaultProperties")) {
							target.addBefore("defaultProperties", source);
						}
						else {
							target.addLast(source);
						}
					}
				}
			}
		}
		finally {
			while (capture != null) {
				capture.close();
				ApplicationContext parent = capture.getParent();
				if (parent instanceof ConfigurableApplicationContext) {
					capture = (ConfigurableApplicationContext) parent;
				} else {
					capture = null;
				}
			}
		}
	}
	private Map<String, Object> changes(Map<String, Object> before,
			Map<String, Object> after) {
		Map<String, Object> result = new HashMap<String, Object>();
		for (String key : before.keySet()) {
			if (!after.containsKey(key)) {
				result.put(key, null);
			}
			else if (!equal(before.get(key), after.get(key))) {
				result.put(key, after.get(key));
			}
		}
		for (String key : after.keySet()) {
			if (!before.containsKey(key)) {
				result.put(key, after.get(key));
			}
		}
		return result;
	}

	private boolean equal(Object one, Object two) {
		if (one == null && two == null) {
			return true;
		}
		if (one == null || two == null) {
			return false;
		}
		return one.equals(two);
	}

	private Map<String, Object> extract(MutablePropertySources propertySources) {
		Map<String, Object> result = new HashMap<String, Object>();
		for (PropertySource<?> parent : propertySources) {
			if (!standardSources.contains(parent.getName())) {
				extract(parent, result);
			}
		}
		return result;
	}

	private void extract(PropertySource<?> parent, Map<String, Object> result) {
		if (parent instanceof CompositePropertySource) {
			try {
				for (PropertySource<?> source : ((CompositePropertySource) parent)
						.getPropertySources()) {
					extract(source, result);
				}
			}
			catch (Exception e) {
				return;
			}
		}
		else if (parent instanceof EnumerablePropertySource) {
			for (String key : ((EnumerablePropertySource<?>) parent).getPropertyNames()) {
				result.put(key, parent.getProperty(key));
			}
		}
	}
}
