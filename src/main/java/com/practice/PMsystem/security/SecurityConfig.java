package com.practice.PMsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated()
                        .requestMatchers("/").hasAnyRole() // HAVE TO FINISH THIS!!!
                        .requestMatchers("/listOfUsers").hasAnyRole()
                        .requestMatchers("/listOfUsersByOrderByUsernameAsc").hasAnyRole()
                        .requestMatchers("/listOfUsersByOrderByEnabledAsc").hasAnyRole()
                        .requestMatchers("/access-denied").hasAnyRole()
                        .requestMatchers("/newUserForm").hasRole("")
                        .requestMatchers("/saveNewUser").hasRole("")
                        .requestMatchers("/showFromForUserUpdate").hasRole("")
                        .requestMatchers("/delete").hasRole("")

                )
                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/access-denied")
                )
                .formLogin(form ->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                );
        return http.build();
    }
}
