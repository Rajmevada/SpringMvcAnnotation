package com.rajmevada.configure;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * this class is act as a WEb-XML file.
 * WebApplicationInitializer method is invoke on startup of web container call and load startup method and class.
 * you can use WebApplicationInitializer or AbstractAnnotationCiinfigDishpatcherServletInitializer.
 * 
 * 
 * @author raj
 *
 */
public class ProjectInitAsWebXml implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringXmlConfigure.class);
		context.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(context));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}
