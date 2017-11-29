package com.rajmevada.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This configuration creates a Servlet Filter known as the
 * 
 * springSecurityFilterChain
 * 
 * which is responsible for all the security (protecting the application URLs,
 * validating submitted username and passwords, redirecting to the log in form,
 * etc) within our application.
 * 
 * @author raj
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Method formLogin provides support for form based authentication and will
	 * generate a default form asking for user credentials.
	 * 
	 * exceptionHandling().accessDeniedPage() which in this case will catch all
	 * 403 [http access denied] exceptions and display our user defined page
	 * instead of showing default HTTP 403 page
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/home").permitAll().antMatchers("/admin/**")
				.access("hasRole('ADMIN')").antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')").and()
				.formLogin().and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}

	/**
	 * This AuthenticationManagerBuilder creates AuthenticationManager which is
	 * responsible for processing any authentication request
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("dba").roles("ADMIN", "DBA");

	}
}
