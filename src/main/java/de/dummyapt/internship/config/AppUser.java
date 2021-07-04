package de.dummyapt.internship.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AppUser implements UserDetails {
    /**
     * Class attribute for username
     */
    private Long id;
    /**
     * Class attribute for username
     */
    private String username;
    /**
     * Class attribute for username
     */
    private String email;
    /**
     * Class attribute for password
     */
    private String password;
    /**
     * Class attribute for roles
     */
    private AppUserRole appUserRole;
    /**
     * Class attribute for roles
     */
    private Boolean locked;
    /**
     * Class attribute for roles
     */
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}