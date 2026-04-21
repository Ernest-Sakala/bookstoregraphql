package com.cs.unza.zm.bookstore.service;


import com.cs.unza.zm.bookstore.config.web.JwtUtils;
import com.cs.unza.zm.bookstore.model.User;
import com.cs.unza.zm.bookstore.repository.UserRepository;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Record used as the return value for register/login GraphQL mutations. */
record AuthPayload(String token, Long userId, String name, String email, String role) {}

@Service
@Transactional
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder       encoder;
    private final AuthenticationManager authManager;
    private final JwtUtils jwt;

    public AuthService(UserRepository repo, PasswordEncoder encoder, AuthenticationManager authManager, JwtUtils jwt) {
        this.repo       = repo;
        this.encoder    = encoder;
        this.authManager = authManager;
        this.jwt        = jwt;
    }

    public AuthPayload register(String name, String email, String password) {
        if (repo.existsByEmail(email))
            throw new IllegalArgumentException("Email already registered: " + email);

        User user = repo.save(User.builder()
            .name(name).email(email)
            .password(encoder.encode(password))
            .build());

        return payload(user);
    }

    public AuthPayload login(String email, String password) {
        // Throws BadCredentialsException if wrong
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(email, password));

        User user = repo.findByEmail(email).orElseThrow();
        return payload(user);
    }

    private AuthPayload payload(User u) {
        return new AuthPayload(
            jwt.generateToken(u.getEmail()),
            u.getId(), u.getName(), u.getEmail(),
            u.getRole().name()
        );
    }
}
