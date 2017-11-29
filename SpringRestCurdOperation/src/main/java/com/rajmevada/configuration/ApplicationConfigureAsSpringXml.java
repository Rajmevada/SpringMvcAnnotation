package com.rajmevada.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rajmevada")
public class ApplicationConfigureAsSpringXml extends WebMvcConfigurerAdapter {

	
//	this line shows that if your parameter is xml send application/xml and if json then send application/json
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		configurer.favorParameter(false).favorParameter(true).parameterName("test")
				.defaultContentType(MediaType.APPLICATION_JSON).mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}

	// @Bean
	// public ContentNegotiationManagerFactoryBean contentNegotiationManager(){
	// ContentNegotiationManagerFactoryBean bean=new
	// ContentNegotiationManagerFactoryBean();
	// bean.setFavorParameter(true);
	// bean.setFavorPathExtension(false);
	// bean.setParameterName("type");
	// Properties properties=new Properties();
	// properties.setProperty("json", "application/json");
	// properties.setProperty("xml", "application/xml");
	// bean.setMediaTypes(properties);
	// return bean;
	// }

}
