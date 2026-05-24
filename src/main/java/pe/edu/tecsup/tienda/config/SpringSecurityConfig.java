package pe.edu.tecsup.tienda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();    // Algoritmo BCrypt
    }

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
    }

}
