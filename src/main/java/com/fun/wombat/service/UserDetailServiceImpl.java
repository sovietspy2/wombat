package com.fun.wombat.service;

import com.fun.wombat.config.CustomUserDetail;
import com.fun.wombat.repository.AuthenticationUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    private final AuthenticationUserRepository authenticationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return authenticationUserRepository.findAuthenticationUserByName(s).map(CustomUserDetail::new)
                .orElseThrow( ()-> new UsernameNotFoundException("user does not exist"));
    }
}
