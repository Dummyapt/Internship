package de.dummyapt.internship.config;

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

@Entity
@Table(name = "users", schema = "internship")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor
public class AppUser implements UserDetails {
    /**
     * Class attribute for username
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    /**
     * Class attribute for roles
     */
    private Boolean locked;
    /**
     * Class attribute for roles
     */
    private Boolean enabled;

    /**
     * Constructor with no id
     * @param username Username
     * @param email Email address
     * @param password Password
     * @param appUserRole User roles
     * @param locked Is the user locked?
     * @param enabled Is the user enabled?
     */
    public AppUser(String username,
                   String email,
                   String password,
                   AppUserRole appUserRole,
                   Boolean locked,
                   Boolean enabled) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
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