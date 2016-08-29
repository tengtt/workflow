package com.workflow.util;

import org.activiti.engine.identity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DefaultFilter implements Filter{
	private static final Log log = LogFactory.getLog(DefaultFilter.class);
	private static final String URL_FILTER = "urlFilter";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURL().toString();
		User user = (User)(httpRequest.getSession().getAttribute("SESSION_USER"));

		if(user == null && !url.contains("logon") && !url.contains("/main/index") && !url.contains("logo") && !url.contains("login")){
			log.info("Session失效");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/main/index");
			dispatcher.forward(request, response); 
    		return;
		}	
		//将控制器传向下一个filter
        chain.doFilter(request, response);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
