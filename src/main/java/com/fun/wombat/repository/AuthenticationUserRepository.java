package com.fun.wombat.repository;

import com.fun.wombat.model.AuthenticationUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationUserRepository extends CrudRepository<AuthenticationUser, Integer> {

    Optional<AuthenticationUser> findAuthenticationUserByName(String name);

}
