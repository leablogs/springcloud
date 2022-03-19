package com.leablogs.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers("/", "/home")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.permitAll()
			.and()
			.logout()
			.permitAll()
			.and()
			.csrf()
			.ignoringAntMatchers("/logout");
		httpSecurity.logout().logoutSuccessUrl("");
		httpSecurity.csrf().disable();
		httpSecurity.rememberMe();
	}
}
