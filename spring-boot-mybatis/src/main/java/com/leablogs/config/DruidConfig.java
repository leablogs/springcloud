package com.leablogs.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}

	@Bean
	public ServletRegistrationBean statViewServlet() {
//		ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<DruidStatProperties.StatViewServlet>(
//				new com.alibaba.druid.support.http.StatViewServlet(), "/druid/*");
		ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(
				new StatViewServlet(), "/druid/*");
		Map<String, String> initParas = new HashMap<String, String>();
		initParas.put("loginUsername", "admin");
		initParas.put("loginPassword", "123456");
		initParas.put("allow", "");
//		initParas.put("deny", "");
		initParas.put("resetEnable", "false");
		bean.setInitParameters(initParas);
		return bean;
	}

	@Bean
	public FilterRegistrationBean webStatFilter() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		bean.addUrlPatterns("/*");
		Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("exclusions", "*.js,*.csss,/druid/*");
		bean.setInitParameters(initParams);
		return bean;
	}
}
