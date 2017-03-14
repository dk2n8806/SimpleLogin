package com.admin.config.bootstrap;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.admin.config.RestServletContextConfiguration;
import com.admin.config.RootContextConfig;
import com.admin.config.WebServletContextConfig;
import com.admin.config.secure.PreSecurityLoggingFilter;


@Order(1)
public class Bootstrap implements WebApplicationInitializer 
{
	@Override
	public void onStartup(ServletContext container)
			throws ServletException {
	
		AnnotationConfigWebApplicationContext rootContext = 
																	new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfig.class);
		container.addListener(new ContextLoaderListener(rootContext));
		
		//XmlWebApplicationContext servletContext = new XmlWebApplicationContext();
		//servletContext.setConfigLocation("classpath:config/spring-servlet.xml");
		
		AnnotationConfigWebApplicationContext servletContext = 
																	new AnnotationConfigWebApplicationContext();
		servletContext.register(WebServletContextConfig.class);
		ServletRegistration.Dynamic dispatcher = container.addServlet(
				 			"SpringDispatcher", new DispatcherServlet(servletContext));
		 
		dispatcher.setLoadOnStartup(1);	
		dispatcher.setMultipartConfig(
								new MultipartConfigElement(
										null, 1024*1024*5, 1024*1024*5*5, 1024*1024));
		dispatcher.addMapping("/");
		
		
		AnnotationConfigWebApplicationContext restContext =
							new AnnotationConfigWebApplicationContext();
		restContext.register(RestServletContextConfiguration.class);
		DispatcherServlet restServlet = new DispatcherServlet(restContext);
		restServlet.setDispatchOptionsRequest(true);
		dispatcher = container.addServlet("springRestDispatcher", restServlet);
		dispatcher.setLoadOnStartup(2);
		dispatcher.addMapping("/services/Rest/*");
		
		FilterRegistration.Dynamic registration = 
					container.addFilter("preSecurityLogingFilter", new PreSecurityLoggingFilter());
		
		registration.addMappingForUrlPatterns(null, false, "/*");
	}
}
