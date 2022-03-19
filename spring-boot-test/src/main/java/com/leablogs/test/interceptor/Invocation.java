package com.leablogs.test.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.Data;

@Data
public class Invocation {
	private Object[] params;
	private Method method;
	private Object targe;

	public Invocation(Object target, Method method, Object[] params) {
		super();
		this.params = params;
		this.method = method;
		this.targe = target;
	}

	public Object proceed() throws InvocationTargetException, IllegalAccessException {
		return method.invoke(targe, params);

	}
}
