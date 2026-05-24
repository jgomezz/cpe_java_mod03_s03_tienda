package pe.edu.tecsup.tienda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();    // Algoritmo BCrypt
    }

    /*
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {

        List<UserDetails> users = new ArrayList<UserDetails>();

        users.add(User.withUsername("user01")
                .password(passwordEncoder().encode("456789"))
                .roles("USER").build());
        users.add(User.withUsername("admin")
                .password(passwordEncoder().encode("nose"))
                .roles("USER","ADMIN").build());

        return new InMemoryUserDetailsManager(users);
    }*/


    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    // Autorizacion

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Configuracion de accesos
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(
                                "/" ,
                                "/webjars/**",
                                "/css/**",
                                "/error/**").permitAll()
                        .requestMatchers(
                                "/productos/**",
                                "/profile").authenticated())
                    // Login
                    .formLogin((form) -> form
                            .loginProcessingUrl("/authenticate")
                            .loginPage("/login").permitAll()
                            .defaultSuccessUrl("/", true)
                    )
                    // Logout
                    .logout((logout) -> logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/login")
                    )
                    // Change csrf
                    .csrf( (csrf) -> csrf.disable()

                );

        return http.build();
    }

}
