package dh.backend.clinicamvc.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth ->
                {
                    // Endpoints sin autenticación
                    auth.requestMatchers("/api/auth/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/odontologos/**").permitAll();

                    // Endpoints para swagger
                    auth.requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll();

                    // Endpoints con roles específicos
                    auth.requestMatchers(HttpMethod.POST, "/odontologos/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT, "/odontologos/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE, "/odontologos/**").hasRole("ADMIN");

                    auth.requestMatchers(HttpMethod.POST, "/pacientes/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT, "/pacientes/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE, "/pacientes/**").hasRole("ADMIN");

                    // Endpoints que requieren autenticación
                    auth.requestMatchers("/turnos/**").authenticated();
                    auth.requestMatchers(HttpMethod.GET, "/pacientes/**").authenticated();

                    // Cualquier otra solicitud debe estar autenticada
                    auth.anyRequest().authenticated();
                })
                .csrf(config -> config.disable()) // SOLO PARA THYMELEAF
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .build();
    }
}
