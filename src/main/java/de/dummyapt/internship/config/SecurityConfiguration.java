package de.dummyapt.internship.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * {@link org.springframework.security.config.annotation.web.configuration.EnableWebSecurity} for Authentication service
 * and authorization services. Handles permissions and role allocation.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * Class attribute providing methods from {@link org.springframework.security.core.userdetails.UserDetailsService}
     */
    private final UserDetailsService userDetailsService;

    /**
     * Internally auto wiring class attributes with parameters
     * @param userDetailsService Needed for autowiring
     */
    @Autowired
    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole("ADMIN")
                .antMatchers("/stats").hasRole("ADMIN")
                .antMatchers("/api/v1/commodities").permitAll()
                .antMatchers("/api/v1/products").permitAll()
                .antMatchers("/api/v1/statistics").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout").permitAll();
    }

    /**
     * Encoding your password so it gets handled with salting and
     * hashing algorithms rather than using plain text method to
     * authenticate your account.
     * @return Encoded password
     */
    // TODO: 30.06.2021 Change to BcryptEncoder
    // TODO: 30.06.2021 Watch tutorial
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}