
package com.portfolio.PortfolioBackend.security;

import com.portfolio.PortfolioBackend.security.jwt.JwtEntryPoint;
import com.portfolio.PortfolioBackend.security.jwt.JwtTokenFilter;
import com.portfolio.PortfolioBackend.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Manuel Gutiérrez
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    
    @Autowired
    private JwtEntryPoint jstEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //http.cors();
        http.cors()
            .and()
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.POST, "/auth/login", "/auth/crear").permitAll() //esto permite accerder a cualquiera al login
            .anyRequest().authenticated() //esto hace que el resto de los endpoint reuqieran autenticacion para acceder a ellos
            .and()
            .exceptionHandling().authenticationEntryPoint(jstEntryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.addFilterBefore(this.jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    
}
