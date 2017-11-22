package com.rajmevada.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.rajmevada.controller.RequestController;

/**
 * this class is act as an Spring-XML file. where you can set beans and various
 * path selection strategy.
 * 
 * @EnableWebMvn using these annotation you can use functionality of @controller
 *               class in project and which equivalent to
 *               <mvc:annotation-driven>.
 * 
 * @ComponentScan is used to where it can get spring beans and classes for
 *                initialization.
 * 
 * @author raj
 *
 */

@Configuration

@EnableWebMvc

@ComponentScan(basePackages = "com.rajmevada")
public class SpringXmlConfigure {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	// public class SpringXmlConfigure extends
	// AbstractAnnotationConfigDispatcherServletInitializer{
	//
	// @Override
	// protected Class<?>[] getRootConfigClasses() {
	// return new Class[]{
	// RequestController.class
	// };
	// }
	//
	// @Override
	// protected Class<?>[] getServletConfigClasses() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// protected String[] getServletMappings() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
