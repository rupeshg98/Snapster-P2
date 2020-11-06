package com.revature.utility;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

public class CorsConfig {
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    String localURI = "http://localhost:4200";

	    List<String> allowedOrigins = List.of(localURI);
	    final CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(allowedOrigins);
	    configuration.setAllowedMethods(java.util.List.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
	    // setAllowCredentials(true) is important, otherwise:
	    // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
	    configuration.setAllowCredentials(true);
	    // setAllowedHeaders is important! Without it, OPTIONS preflight request
	    // will fail with 403 Invalid CORS request
	    configuration.setAllowedHeaders(java.util.List.of("Authorization", "Cache-Control", "Content-Type", "Access-Control-Allow-Origin"));
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}	
}
