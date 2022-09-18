package com.ukim.mk.projectspring.config;

import com.ukim.mk.projectspring.Service.UsersService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        private final UsersService userService;
        private final PasswordEncoder passwordEncoder;

        public WebSecurityConfig(
                UsersService userService, PasswordEncoder passwordEncoder) {
            this.userService = userService;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.csrf().disable()
                    .authorizeRequests()
//                .antMatchers("/").permitAll()
                    .antMatchers("/login", "/projections", "/**", "/auditoriums", "/reserve/add", "/css/**",
                            "/tests/reserve/projection/add", "/reserve", "/reserve/projection/**","/static/img/",
                            "/view/movies/**", "/", "/movie/projections/detailed-preview/", "/tests", "/home/videos/**",
                            "/videos/**", "/projections/view", "/movies/view/**", "/home","/css/img/**",
                            "/home/**", "/assets/**", "/register", "/movies", "/api/**", "/logout","/api/login").permitAll()
                    .antMatchers("/admin/**", "/projections/add-form", "/movies/add-form").hasRole("EMPLOYEE")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    //.loginPage("/login").permitAll()
                    .failureUrl("/login?error=BadCredentials")
                    .defaultSuccessUrl("/home", true)
                    .and()
                    .logout()
                    .logoutUrl("/logout")

                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/home")
                    .and()
                    .exceptionHandling().accessDeniedPage("/access_denied");

        }

        //@Bean
        //public JWTAuthorizationFilter authorizationFilter() throws Exception {
        //    return new JWTAuthorizationFilter(authenticationManager(), userService);
        //}

        //@Bean
        //public JwtAuthenticationFilter authenticationFilter() throws Exception {
        //    return new JwtAuthenticationFilter(authenticationManager(), userService, passwordEncoder, userService);
       // }

    }

