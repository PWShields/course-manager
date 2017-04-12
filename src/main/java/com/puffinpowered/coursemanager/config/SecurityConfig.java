package com.puffinpowered.coursemanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.puffinpowered.coursemanager.security.Role.ADMIN;
import static com.puffinpowered.coursemanager.security.Role.USER;
import static com.puffinpowered.coursemanager.security.UrlPath.*;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles(ADMIN.name())
                .and()
                .withUser("user")
                .password("user")
                .roles(USER.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(ADMIN_ACCESS_REQUIRED_PATH.value()).hasRole(ADMIN.name());
        http
                .formLogin()
                .defaultSuccessUrl(DEFAULT_LOGIN_SUCCESS.value())
                .loginPage(LOGIN_PATH.value())
                .failureUrl(LOGIN_FAILURE_PATH.value())
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl(DEFAULT_LOGIN_SUCCESS.value())
                .permitAll();

//        .loginProcessingUrl("/login")
    }
}
