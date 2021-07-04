package de.dummyapt.internship.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

/**
 * Spring model of the users table
 */
@Entity
@Table
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor
public class AppUser implements UserDetails {
    /**
     * Class attribute annotated as table column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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