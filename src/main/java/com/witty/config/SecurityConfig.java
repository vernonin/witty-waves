package com.witty.config;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.witty.common.HttpResponses;
import com.witty.execption.AuthenticationEntryPointImpl;
import com.witty.utils.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtRequestFilter jwtRequestFilter;
    private final UserDetailsService userDetailsService;
    private final AuthenticationEntryPointImpl authenticationEntryPoint;

    private static final String[] apisPass = {
            "/auth/login", "/auth/register"
    };

    private static final String[] swaggerPass = {
            "/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/*/api-docs", "/druid/**"
    };

    public SecurityConfig(UserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter, com.witty.execption.AuthenticationEntryPointImpl authenticationEntryPointImpl) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        authenticationEntryPoint = authenticationEntryPointImpl;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(apisPass).permitAll()
                .antMatchers(HttpMethod.GET, "/", "/*.html").permitAll()
                .antMatchers(swaggerPass).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling(exceptoin -> exceptoin.authenticationEntryPoint(authenticationEntryPoint))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // 显式指定过滤器的顺序
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
