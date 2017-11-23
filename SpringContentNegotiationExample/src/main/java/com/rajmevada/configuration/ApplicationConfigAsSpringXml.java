package com.rajmevada.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.rajmevada.model.Pizza;
import com.rajmevada.viewresolver.Jaxb2MarshallingXmlViewResolver;
import com.rajmevada.viewresolver.JsonViewResolver;

/**
 * in this program when project loading it will be bind all classes like if
 * extension is XML then check all resolver view property of their content-type
 * and then when request arrives it will call class configureContentNegotiation
 * and it will decide which resolver to be call and then go to controller and
 * return view by decided view resolver..
 * 
 * @author raj
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rajmevada")
public class ApplicationConfigAsSpringXml extends WebMvcConfigurerAdapter {

	/**
	 * decides which resolver will be call and you can also create new extension
	 * and media-type for that like
	 * 
	 * here i have created .apk extension for image-jpeg so when we hit
	 * extension like .apk it will invoke resolver which view returns
	 * content-type as image jpeg. configurer.mediaType(".apk",
	 * MediaType.IMAGE_JPEG_VALUE);
	 * 
	 * after that response from controller is received it will be call class
	 * which has parameter as ContentNegotiationManager for which class is call
	 * now
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver negotiatingViewResolver = new ContentNegotiatingViewResolver();
		negotiatingViewResolver.setContentNegotiationManager(manager);

		List<ViewResolver> resolvers = Arrays.asList(jspViewResolver(), jsonViewResolver(), xmlViewResolver());
		negotiatingViewResolver.setViewResolvers(resolvers);
		return negotiatingViewResolver;
	}

	
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix("/Web-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	/**
	 * this resolver returns view as return which have property like
	 * content-type so ContentNegotiationConfigurer checks it and decides what
	 * type of content it will return
	 * 
	 * @return View with content-type with application/json.
	 */
	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}

	@Bean
	public ViewResolver xmlViewResolver() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Pizza.class);
		return new Jaxb2MarshallingXmlViewResolver(marshaller);
	}

}
