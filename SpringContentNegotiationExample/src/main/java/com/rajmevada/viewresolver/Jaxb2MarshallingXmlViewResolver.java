package com.rajmevada.viewresolver;

import java.util.Locale;

import org.springframework.oxm.Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

public class Jaxb2MarshallingXmlViewResolver implements ViewResolver {

	private Marshaller marshaller;

	public Jaxb2MarshallingXmlViewResolver(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	/**
	 * you can see here i have used MarshallingView class now click on that
	 * class you can see there
	 * 
	 * public static final String DEFAULT_CONTENT_TYPE = "application/xml";
	 * 
	 * this variable is set as by default so returning view with this
	 * content-type so by that ContentNegotiation class decides which resolver
	 * is suitable.
	 */
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		MarshallingView view = new MarshallingView();
		view.setMarshaller(marshaller);
		return view;
	}

}
