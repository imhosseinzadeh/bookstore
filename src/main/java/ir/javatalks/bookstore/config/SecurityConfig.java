package ir.javatalks.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static ir.javatalks.bookstore.entity.security.Role.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
/*
                .requestMatchers(HttpMethod.GET, "/books/**").hasAnyRole(USER.name(), CUSTOMER.name(), ADMIN.name())
                .requestMatchers(HttpMethod.POST, "/books/**").hasAnyAuthority(BOOK_WRITE.name())
                .requestMatchers(HttpMethod.PUT, "/books/**").hasAnyAuthority(BOOK_WRITE.name())
                .requestMatchers(HttpMethod.DELETE, "/books/**").hasAnyAuthority(BOOK_WRITE.name())
*/
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("iman")
                .password(passwordEncoder().encode("admin"))
//                .roles(Role.ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails customer = User.withUsername("arash")
                .password(passwordEncoder().encode("customer"))
//                .roles(Role.CUSTOMER.name())
                .authorities(CUSTOMER.getGrantedAuthorities())
                .build();

        UserDetails user = User.withUsername("reza")
                .password(passwordEncoder().encode("user"))
//                .roles(Role.USER.name())
                .authorities(USER.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(admin, customer, user);
    }

}
