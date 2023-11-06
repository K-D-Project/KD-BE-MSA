package com.example.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KDUserDetailsService implements UserDetailsService {

    private final KDUserRepository userRepository;
    private final KDRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        KDUser u = userRepository.findByUser_id(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );

        List<KDRole> r = u.getRoles();

        return KDUserDetails.builder()
                .user_id(u.getUser_id())
                .password(u.getPassword())
                .email(u.getEmail())
                .authorities(r.stream().map(role -> {
                    return new SimpleGrantedAuthority(role.getType());
                }).collect(Collectors.toSet()))
                .build();
    }
}
