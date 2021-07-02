package com.fun.wombat.controller;

import com.fun.wombat.model.AuthenticationUser;
import com.fun.wombat.repository.AuthenticationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fun.wombat.model.Language;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationUserRepository authenticationUserRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/register")
    public String register(@RequestBody AuthenticationUser wannaBeUser) throws Exception {

        Optional<AuthenticationUser> user = authenticationUserRepository.findAuthenticationUserByName(wannaBeUser.getName());

        if (user.isPresent()) {
            throw new Exception("USER ALREADY EXIST WITH THIS NAME");
        }


        AuthenticationUser newUser = AuthenticationUser.builder()
                .name(wannaBeUser.getName())
                .password(bCryptPasswordEncoder.encode(wannaBeUser.getPassword()))
                .language(wannaBeUser.getLanguage())
                .build();


        authenticationUserRepository.save(newUser);

        return "ok";
    }

}
