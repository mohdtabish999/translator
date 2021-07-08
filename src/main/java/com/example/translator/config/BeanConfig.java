package com.example.translator.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

@Configuration
public class BeanConfig extends WebSecurityConfigurerAdapter {
	
	  @Bean public ViewResolver contentNegotiatingViewResolver() {
	  ContentNegotiatingViewResolver resolver = new
	  ContentNegotiatingViewResolver();
	  
		List<View> views = new ArrayList<>();
		views.add(new MappingJackson2XmlView());
		views.add(new MappingJackson2JsonView());

	  resolver.setDefaultViews(views); return resolver; 
	  }
	  
	  @Override
		protected void configure(HttpSecurity http) throws Exception {
			
			/*
			 * http.authorizeRequests(authz ->
			 * authz.antMatchers("/foos/**").hasAuthority("SCOPE_message.read")
			 * .antMatchers(HttpMethod.POST,
			 * "/foos").hasAuthority("SCOPE_message.write").anyRequest().authenticated())
			 * .oauth2ResourceServer(oauth2 -> oauth2.jwt());
			 */

			http.csrf().disable().authorizeRequests().antMatchers("/", "/error**").permitAll().anyRequest()
					.authenticated().and().oauth2ResourceServer().jwt();

				/*
				 * http .mvcMatcher("/foos/**") .authorizeRequests()
				 * .mvcMatchers("/foos/**").access("hasAuthority('SCOPE_message.read')") .and()
				 * .oauth2ResourceServer() .jwt();
				 */
		}
	 
}