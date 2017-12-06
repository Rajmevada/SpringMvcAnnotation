package com.rajmevada.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint; 
	
	@Autowired
	public void configureGlobelSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("raj").password("raj").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("anu").password("anu").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.csrf().disable()
		 .authorizeRequests()
		 .antMatchers("/create").permitAll()
		 .antMatchers("/users").access("hasRole('ADMIN')")
		 .and().httpBasic().realmName("Sample").authenticationEntryPoint(customAuthenticationEntryPoint)
		 .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
}
