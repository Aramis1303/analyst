package ru.evaproj.analyst.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.evaproj.analyst.services.UserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/workspace").hasRole("USER")
                .antMatchers("/analysis/**").hasRole("CUSTOMER")
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/").permitAll()
                .and()
                .logout()
                .permitAll();
        http
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false);
    }


}
