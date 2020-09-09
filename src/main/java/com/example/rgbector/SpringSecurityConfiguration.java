package com.example.rgbector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.rgbector.models.services.UsuarioService;
import com.example.rgbector.security.LoginSuccessHandler;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService service;

	@Autowired
	private LoginSuccessHandler handler;

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired // Authetication
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(service).passwordEncoder(encoder());
	}

	@Override // Autorization
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/css/**", "/img/**", "/js/**", "/scss/**", "/vendor/**").permitAll()
				.antMatchers("/usuario/**").hasAnyRole("USER")
				.antMatchers("/usuarios/**").hasAnyRole("USER")
				.antMatchers("/tipoUsuario/**").hasAnyRole("USER")
				.antMatchers("/h2-console/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				.and().formLogin().successHandler(handler).permitAll()
				.and().logout().permitAll()
				.and().exceptionHandling().accessDeniedPage("/error_403")
				.and()
					.csrf().ignoringAntMatchers("/h2-console/**")
				.and()
					.headers().frameOptions().sameOrigin();
	}
}