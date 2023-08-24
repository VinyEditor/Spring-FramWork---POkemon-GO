package com.seunome.projeto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/public/**").permitAll() // URLs públicas permitidas
                .antMatchers("/usuarios/**").authenticated() // URLs protegidas, exige autenticação
                // Adicione mais regras de autorização conforme necessário
            .and()
            .formLogin()
                .loginPage("/login") // Página de login personalizada
                .defaultSuccessUrl("/dashboard") // Página após o login bem-sucedido
                .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl("/login") // Página após o logout bem-sucedido
                .permitAll();
    }
}
