package com.cs.unza.zm.bookstore.controller;


import com.cs.unza.zm.bookstore.service.AuthService;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.Map;

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
    public Object register(@Argument Map<String, String> input) {
        return authService.register(
            input.get("name"),
            input.get("email"),
            input.get("password")
        );
    }

    @MutationMapping
    public Object login(@Argument Map<String, String> input) {
        return authService.login(
            input.get("email"),
            input.get("password")
        );
    }
}
