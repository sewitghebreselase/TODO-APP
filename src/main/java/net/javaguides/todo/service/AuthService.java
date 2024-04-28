package net.javaguides.todo.service;


import net.javaguides.todo.dto.UserRequest;
import net.javaguides.todo.dto.UserResponse;

public interface AuthService {
    UserResponse login(UserRequest loginRequest);
//    UserResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
