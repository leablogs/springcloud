package com.leablogs.plugs;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.rabbitmq.client.AMQP.Connection;

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class MyPlugs implements Interceptor {
	Properties properties = null;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("插件拦截方法：。。。。");
		return null;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
