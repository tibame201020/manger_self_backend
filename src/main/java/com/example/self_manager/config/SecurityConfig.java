package com.example.self_manager.config;

import com.example.self_manager.filter.CustomAuthorizaionFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import static com.example.self_manager.constant.SecurityConstant.PASS_URLS;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       http.authorizeRequests().antMatchers(PASS_URLS)
               .permitAll();
       http.authorizeRequests().anyRequest().authenticated();
       http.addFilterBefore(new CustomAuthorizaionFilter(), UsernamePasswordAuthenticationFilter.class);
       http.cors().and().csrf().disable();
       http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }

}
