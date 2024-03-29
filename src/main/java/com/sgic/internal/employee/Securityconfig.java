package com.sgic.internal.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@SuppressWarnings("deprecation")
	@Bean
	public DaoAuthenticationProvider authprovider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/Login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/Login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/Logout"))
		.logoutSuccessUrl("/logout success").permitAll();
		
	}
	
	

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("employee").password("1234").roles("USER").build());
//		return new InMemoryUserDetailsManager(users);
//	}

}
