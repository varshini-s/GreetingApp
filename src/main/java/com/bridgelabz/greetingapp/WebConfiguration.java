package com.bridgelabz.greetingapp;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javassist.tools.web.Webserver;

@Configuration
public class WebConfiguration 
{
	
	@Bean
	ServletRegistrationBean h2ServletRegistration()
	{
		
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/h2/*");
		return registrationBean;
	}

}
