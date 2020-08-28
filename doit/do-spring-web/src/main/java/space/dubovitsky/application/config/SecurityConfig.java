package space.dubovitsky.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import space.dubovitsky.application.security.AuthProviderImpl;

@Configuration
@EnableWebSecurity
@ComponentScan("space.dubovitsky.application")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProviderImpl authProvider; //? Почему тут сервис не работает?

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/auth/login", "/auth/register").anonymous()
                    .antMatchers("/user/list").authenticated()
                .and()
                    .csrf().disable()
                    .formLogin().loginPage("/auth/login")
                    .loginProcessingUrl("/auth/login/process")
                    .failureUrl("/auth/login?error=true")
                    .usernameParameter("email") //! Так называется параметр, который передается в форме login.ftl
                .and()
                    .logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(authProvider); //* Подвязываем механизм аутентификации
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
