package com.teksen.studentcruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SimpleSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/v1/students").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/v1/students/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/students").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/students").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/students/**").hasRole("ADMIN")

        );

        httpSecurity.httpBasic();

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }






}
