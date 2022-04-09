package com.mat.springsecurity.core.security;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration @EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override @SneakyThrows
    protected void configure(AuthenticationManagerBuilder auth){
         auth.inMemoryAuthentication()
                    .withUser("MAT").password(passwordEncoder().encode("123456")).roles("ADMIN")
                .and()
                    .withUser("caixa").password(passwordEncoder().encode("123456")).roles("USER");
    }

    @Override @SneakyThrows
    protected void configure(HttpSecurity http)  {
        http.httpBasic()
                .and()
                    .authorizeRequests()
                         .anyRequest().authenticated()
                .and()
                    .sessionManagement()
                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
