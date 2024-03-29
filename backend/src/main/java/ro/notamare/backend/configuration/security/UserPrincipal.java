package ro.notamare.backend.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.notamare.backend.entities.AbstractUser;

import java.util.Collection;
import java.util.LinkedList;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {

    private final AbstractUser user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new LinkedList<>();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return true;
        //TODO use registration validation
        //return user.isEnabled();
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

    public AbstractUser getAuthenticatedUser() {
        return user;
    }
}
