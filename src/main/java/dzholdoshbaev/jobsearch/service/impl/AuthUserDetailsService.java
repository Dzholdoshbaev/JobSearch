package dzholdoshbaev.jobsearch.service.impl;


import dzholdoshbaev.jobsearch.model.Authorities;
import dzholdoshbaev.jobsearch.model.Roles;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {
    private final UsersRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                getAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Roles> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    private List<String> getPrivileges(Collection<Roles> roles) {
        List<String> privileges = new ArrayList<>();
        List<Authorities> collection = new ArrayList<>();

        for (Roles role : roles) {
            privileges.add(role.getRole());
            collection.addAll(role.getAuthorities());
        }
        for (Authorities item : collection) {
            privileges.add(item.getAuthority());
        }
        return privileges;
    }

}
