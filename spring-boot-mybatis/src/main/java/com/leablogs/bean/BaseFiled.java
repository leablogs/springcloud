package com.leablogs.bean;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

//@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE)
@Scope(ConfigurableListableBeanFactory.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
public class BaseFiled {

	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
