package com.backend.project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.backend.project.security.CustomUserDetailsService;
import com.backend.project.security.JwtAuthenticationEntryPoint;
import com.backend.project.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled = true,
		securedEnabled = true, 
		jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Bean
	public JwtAuthenticationFilter  jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	} 
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/**")
			.permitAll()
			.antMatchers("/api/auth/**").permitAll()
			.antMatchers("/api/publication/**").permitAll()
			.antMatchers("/api/user/**").permitAll()
			.antMatchers("/api/product/**").permitAll()
			.antMatchers("/api/bartable/**").permitAll()
			.antMatchers("/api/master-data/**").permitAll()
			.antMatchers("/api/developer-blog/**").permitAll()
			.antMatchers("/api/contact/**").permitAll()
			.antMatchers("/api/roles/**").permitAll()
			
			.anyRequest()
			.authenticated();
		
		http.addFilterBefore(this.jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(this.customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	

	
	/**
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		UserDetails userDetailsAdmin = User.builder().username("admin").password(passwordEncoder().encode("password")).roles("ADMIN_ROOT").build();
		UserDetails userDetailsUsuario = User.builder().username("ivan").password(passwordEncoder().encode("user")).roles("USER").build();
		
		return new InMemoryUserDetailsManager(userDetailsAdmin, userDetailsUsuario);
	}
	**/
	
}
