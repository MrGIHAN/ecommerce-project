package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.requestDto.LoginRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.JwtResponseDto;
import dev.gihan.e_commerce.api.exception.UserNotFoundException;

public interface AuthService {
    JwtResponseDto authenticate(LoginRequestDto loginRequest) throws UserNotFoundException;
}

