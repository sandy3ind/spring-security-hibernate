package com.javagain.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * @author Sandeep.Sharma
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;
	
	/**
	 * Build Auth manager with in memory users
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}
	
	/**
	 * If using spring 4+ then CSRF enabled by default and logout uses POST method
	 * Disabling CSRF will use GET method for logout
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable()
	  	.authorizeRequests()
	  		.antMatchers("/users/registration","/users/save").permitAll()
	  		.antMatchers("/users/admin/**").access("hasRole('ROLE_ADMIN')")
	  		.antMatchers("/users/user/**").access("hasRole('ROLE_USER')")
	  		.antMatchers("/users/dba/**").access("hasRole('ROLE_DBA')")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login").permitAll()
		    .defaultSuccessUrl("/users/home")
		    .failureUrl("/login?error")
			.and()
		.logout()
			.logoutSuccessUrl("/login?logout");
	}
	
	/**
	 * Authentication provider which will be used by Authentication manager to load user
	 * 
	 * @return
	 */
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
	/**
	 * Encrypt password
	 * 
	 * @return
	 */
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
