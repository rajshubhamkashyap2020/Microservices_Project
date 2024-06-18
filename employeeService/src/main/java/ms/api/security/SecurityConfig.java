package ms.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> 
                authorizeRequests
                    .anyRequest().authenticated()
            )
            .oauth2Login(oauth2Login -> 
                oauth2Login
                    .defaultSuccessUrl("/api/home", true)
                    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
            )
            .logout(logout -> 
                logout
                    .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
            )
            .csrf(csrf -> csrf.disable()); 

        return http.build();
    }
}