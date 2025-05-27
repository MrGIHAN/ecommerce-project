package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.configuration.JwtUtil;
import dev.gihan.e_commerce.api.dto.requestDto.LoginRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.JwtResponseDto;
import dev.gihan.e_commerce.api.exception.UserNotFoundException;
import dev.gihan.e_commerce.api.model.User;
import dev.gihan.e_commerce.api.repository.UserRepository;
import dev.gihan.e_commerce.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public JwtResponseDto authenticate(LoginRequestDto loginRequest) throws UserNotFoundException {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UserNotFoundException("Invalid user"));

        String token = jwtUtil.generateToken(user);

        return new JwtResponseDto(token, user.getRole().name(), user.getUsername());
    }
}

