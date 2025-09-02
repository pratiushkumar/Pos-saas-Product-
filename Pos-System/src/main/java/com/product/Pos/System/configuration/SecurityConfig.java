package com.product.Pos.System.configuration;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration

public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecure
    ) throws Exception {
HttpSecurity httpSecurity = httpSecure.sessionManagement(management->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(Authorize-> Authorize.requestMatchers("/api/**").authenticated())
        .requestMatchers("/api/super-admin/**").hasRole("ADMIN").anyRequest().permitAll()
        ).addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class)
                .csrf(AbstractHttopConfigurer::disable).cors(
                        cors-> cors.configurationSource(corsConfigurationSource())
                ).build();
    }

}

private CorsConfigurationSource corsConfigurationSource() {
    return new CorsConfigurationSource() {
        @Override
        public CorsConfiguration getCorsConfiguration(HttpServletRequest request)
            return null;
    }
}
}

