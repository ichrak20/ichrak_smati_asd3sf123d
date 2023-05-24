package anywr.recruitment.schoolCore.classroom.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return org.springframework.security.core.userdetails.User.builder()
                .username("Jhon Doe")
                .password("Password")
                .roles("ROLE_ADMIN") // Set the user's roles
                .build();
    }
}

