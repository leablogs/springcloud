package com.leablogs.config;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({ @Signature(type = StatementHandler.class, method = "parameterize", args = java.sql.Statement.class) })
public class MybatisPlus implements Interceptor {

	private static Logger logger = LoggerFactory.getLogger(MybatisPlus.class);
	private long time;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		String sql = boundSql.getSql();
		long start = System.currentTimeMillis();
		Object process = invocation.proceed();
		long end = System.currentTimeMillis();
		if((end-start)>time) {
		
			logger.info("本次数据库执行sql语句时间：" + sql);
		}else {
			logger.info("本次查询没有满执行语句");
		}
		return process;
	}

	public Object plugin(Object o) {
		Object wrap = Plugin.wrap(o, this);
		return wrap;
	}

	public void setProperties(Properties properties) {
		this.time = Long.parseLong(properties.getProperty("time"));
	}
}