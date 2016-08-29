package com.workflow.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

public class ApplicationContextUtils {
	
	private static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext(){
		
		if(applicationContext == null){
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
			
		}
		return applicationContext;
	}
	
}
