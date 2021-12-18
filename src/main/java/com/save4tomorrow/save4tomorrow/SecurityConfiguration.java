package com.save4tomorrow.save4tomorrow;

import com.save4tomorrow.save4tomorrow.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader)
                .passwordEncoder(passwordEncoder())
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //Login Configuration
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/challenges/main") // Savings Challenges Main Page
                .permitAll() //Anyone can go to the login page
                //Logout configuration
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout") // append a query string value
                // pages that can ve viewed without having to login in
                .and()
                .authorizeRequests()
                .antMatchers(
//                        "/listing/create", // only authenticated users can create listings
//                        "/listing/{id}/{edit}", // only authenticated users can edit listings
                        "/challenges/main",
                        "/challenges/52Week",
                        "/challenges/weather",
                        "/challenges/noSpend",
                        "/challenges/bingo",
                        "/profile"
                )
                .authenticated()
        ;
    }


}
