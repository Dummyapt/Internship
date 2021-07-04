package de.dummyapt.internship.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    // TODO: 01.07.2021 Add role checking
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/stats").permitAll()
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
     * Encoding your password, so it gets handled with salting and
     * hashing algorithms rather than using plain text method to
     * authenticate your account.
     * @return Encoded password
     * @hidden
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}