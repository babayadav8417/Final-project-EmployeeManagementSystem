package com.FinalProject.EmployeeManagementSystem.Configs;


import com.FinalProject.EmployeeManagementSystem.Security.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private EmployeeDetails employeeDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().and()
                .authorizeRequests()

                .antMatchers(HttpMethod.GET,"/Assets/{id}").hasAnyAuthority( "EMPLOYEE")
                .antMatchers(HttpMethod.GET,"/Organization/{id}").hasAnyAuthority("EMPLOYEE")

                .antMatchers("/Employee/**").hasAnyAuthority("ADMIN")
                .antMatchers("/Assets/**").hasAnyAuthority( "ADMIN")
                .antMatchers("/Organization/**").hasAnyAuthority("ADMIN")




                .anyRequest().authenticated()
        .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.employeeDetails).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
