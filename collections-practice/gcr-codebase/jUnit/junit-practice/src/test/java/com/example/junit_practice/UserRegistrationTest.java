package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    UserRegistration registration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> {
            registration.registerUser(
                    "john_doe",
                    "john@example.com",
                    "secret123"
            );
        });
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(
                    "",
                    "john@example.com",
                    "secret123"
            );
        });
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(
                    "john_doe",
                    "johnexample.com",
                    "secret123"
            );
        });
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(
                    "john_doe",
                    "john@example.com",
                    "123"
            );
        });
    }
}
