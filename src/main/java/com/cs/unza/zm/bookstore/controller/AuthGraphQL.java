package com.cs.unza.zm.bookstore.controller;


import com.cs.unza.zm.bookstore.dto.LoginInput;
import com.cs.unza.zm.bookstore.dto.RegisterInput;
import com.cs.unza.zm.bookstore.service.AuthService;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * GraphQL mutations for authentication.
 *
 * register(input: RegisterInput!): AuthPayload!
 * login(input: LoginInput!):    AuthPayload!
 *
 * NOTE: @Controller (not @RestController) is the correct annotation
 * for Spring for GraphQL resolvers.
 */
@Controller
public class AuthGraphQL {

    private final AuthService authService;

    public AuthGraphQL(AuthService authService) {
        this.authService = authService;
    }

    @MutationMapping
    public Object register(@Argument RegisterInput input) {
        return authService.register(
                input.name(),
                input.email(),
                input.password()
        );
    }

    @MutationMapping
    public Object login(@Argument LoginInput input) {
        return authService.login(
                input.email(),
                input.password()
        );
    }
}
