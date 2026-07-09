package com.demo.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange(exchange -> exchange.pathMatchers("/hr/**").hasRole("USER").pathMatchers("/emp/**")
				.hasRole("ADMIN").anyExchange().authenticated());
		http.csrf(ServerHttpSecurity.CsrfSpec::disable);
		http.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}

	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	MapReactiveUserDetailsService mapReactiveUserDetailsService(PasswordEncoder encoder) {
		 
		UserDetails admin=User.builder().username("shantanu").password(encoder.encode("welcome1")).roles("ADMIN").build();
		UserDetails user=User.builder().username("pavan").password(encoder.encode("welcome1")).roles("USER").build();
		UserDetails other=User.builder().username("other").password(encoder.encode("welcome1")).roles("USER").build();
		return new MapReactiveUserDetailsService(admin,user,other);
	}

	
	
}
