package com.ashu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@ComponentScan({"com.fees.portal"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void  configure(HttpSecurity http)throws Exception{
		
		http
		.csrf()
		.disable()
		.authorizeRequests()
		
		.antMatchers("/**").hasRole("MANAGER")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		//.loginPage("/login.html")
		
//	      .and()  
//	      .logout()  
//	      .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  
		;
		//.defaultSuccessUrl("/common").permitAll();
	}
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication()
		.withUser("ashu").password("{noop}123").roles("MANAGER");
		
	}
}
