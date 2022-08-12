package com.leablogs.intercepter;

import java.io.IOException;
//import java.net.http.HttpClient.Redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

//import com.leablogs.pojo.User;

public class LoginIntercepter implements HandlerInterceptor {
	public Boolean preHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		if(requestURI.indexOf("/login")<=0) {
			HttpSession session = request.getSession();
			return false;
//			User user = (User) request.getAttribute("user");
//			if(user != null) {
//				return true;
//			}else {
//				request.getRequestDispatcher("").forward(request, response);
////				new Redirect
//				return false;
//			}
		}else {
			return false;
		}
	}
}



















