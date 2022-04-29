package kg.alatoo.springwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable() // in thymeleaf you can access csrf code with ${_csrf}
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
//                    .antMatchers("/admin").hasRole("ROLE_ADMIN") // EXAMPLE IF YOU ADD ROLE SPECIFIC ACCESS
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // to customize login page with specific controller
                .loginProcessingUrl("/login")
                .usernameParameter("username") // html name attribute of input tag
                .passwordParameter("password") // html name attribute of input tag
                .failureUrl("/login?error=true")
                .permitAll().and()
                .logout().permitAll();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            return User.builder()
                    .username("admin")
                    .password("admin")
                    .roles("ADMIN")
                    .passwordEncoder(passwordEncoder()::encode)
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new  BCryptPasswordEncoder(7);
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }
}
