package com.bca.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, pw from users where username=? and pw=?")
        .authoritiesByUsernameQuery("select username from users where username=?")
        .passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/administrasi").authenticated()
                .antMatchers("/gantibahasa").authenticated()
                .antMatchers("/gantipw").authenticated()
                .antMatchers("/kartukredit").authenticated()
                .antMatchers("/login").authenticated()
                .antMatchers("/notsaved").authenticated()
                .antMatchers("/pembayaran").authenticated()
                .antMatchers("/pembelian").authenticated()
                .antMatchers("/saved").authenticated()
                .antMatchers("/success").authenticated()
                .antMatchers("/tagihan").authenticated()
                .antMatchers("/transaksi").authenticated()
                .anyRequest().permitAll()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/success")
                .failureUrl("/login")
                .permitAll();
    }

}
    