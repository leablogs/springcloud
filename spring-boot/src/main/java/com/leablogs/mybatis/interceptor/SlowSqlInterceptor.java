package com.leablogs.mybatis.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

/**
 * 慢查询sql统计
 * 支持 executor parameterHandler ResultSetHandler StatementHandler 四种组件方法进行拦截
 */
@Slf4j
@Intercepts({
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class, ResultHandler.class})
})
public class SlowSqlInterceptor implements Interceptor {
    private Integer limitSecond;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long beginTimeMills = System.currentTimeMillis();
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        try {
            return invocation.proceed();
        } finally {
            long endTimeMills = System.currentTimeMillis();
            long costTimeMissl = endTimeMills - beginTimeMills;
            if (costTimeMissl > limitSecond * 1000) {
                BoundSql boundSql = statementHandler.getBoundSql();
                String sql = getFormatedSql(boundSql);
                log.info("SQL语句【{}】，执行耗时：【{}】ms", sql, costTimeMissl);
            }
        }
    }

    private String getFormatedSql(BoundSql boundSql) {
        return "";
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        String limitSecond = (String) properties.get("limitSecond");
//        Interceptor.super.setProperties(properties);
        this.limitSecond = Integer.parseInt(limitSecond);
    }
}

























