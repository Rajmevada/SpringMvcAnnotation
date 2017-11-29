package com.rajmevada.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.rajmevada.utility.CustomRedirectionHandler;

/**
 * Here,
 * formLogin().loginPage("/login").usernameParameter("ssoId").passwordParameter("password")
 * declares thatwe have custom page and to access it you have to go to URL
 * 'login/ and page have parameters names as given there.
 * 
 * CSRF=Cross Site Request Forgery. It is used by spring security after 3.0 in
 * 4.0 you don't have to import it. CSRF is used to secure your transaction type
 * request by CSRF token. by default it comes with default true value if you
 * want to disable it you have to do it manually.
 * 
 * When Security required to your application you have to use it.
 * 
 * If your browser has important credentials then it is useful.
 * 
 * In this project we have used Spring-Tag Library for control elements to which user can access specified page elements.   
 * 
 * @author raj
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomRedirectionHandler  custom; 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/", "/home").permitAll()
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
		.and().formLogin().loginPage("/login").successHandler(custom).usernameParameter("ssoId").passwordParameter("password")
		.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("dba").roles("ADMIN", "DBA");
	}
}
