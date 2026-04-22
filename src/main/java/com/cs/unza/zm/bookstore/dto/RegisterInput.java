package com.cs.unza.zm.bookstore.dto;

public record RegisterInput(
    String name,
    String email,
    String password
) {}