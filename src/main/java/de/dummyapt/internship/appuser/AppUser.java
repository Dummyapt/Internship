package de.dummyapt.internship.appuser;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

/**
 * Spring model of the app_user table
 */
@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class AppUser implements UserDetails {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Class attribute annotated as table column
     */
    private String email;
    /**
     * Class attribute annotated as table column
     */
    private String password;
    /**
     * Class attribute annotated as table column
     */
    @Enumerated(EnumType.STRING)
    private AppUserRole role;
    /**
     * Class attribute annotated as table column
     */
    private Boolean locked = false;
    /**
     * Class attribute annotated as table column
     */
    private Boolean enabled = false;

    /**
     * Constructor witth no id
     * @param email Email address
     * @param password User password
     * @param role Role
     */
    public AppUser(String email,
                   String password,
                   AppUserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}