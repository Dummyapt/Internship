package de.dummyapt.internship.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Technically a Spring model
 */
public class MyUserDetails implements UserDetails {
    /**
     * Class attribute for username
     */
    private final String username;
    /**
     * Class attribute for password
     */
    private final String password;
    /**
     * Class attribute for active
     */
    private final boolean active;
    /**
     * Class attribute for authorities
     */
    private final List<GrantedAuthority> authorities;

    /**
     * This constructor takes an user object and assigns
     * the object's values to the attributes
     * @param myUser User object
     */
    public MyUserDetails(MyUser myUser) {
        this.username = myUser.getUsername();
        this.password = myUser.getPassword();
        this.active = myUser.isActive();
        this.authorities = Arrays.stream(myUser.getAuthorities().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}