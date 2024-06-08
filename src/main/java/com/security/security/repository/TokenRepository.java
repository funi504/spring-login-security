package com.security.security.repository;

import com.security.security.model.BlackListedToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<BlackListedToken, Integer> {

    Optional<BlackListedToken> findByToken(String token);
}
