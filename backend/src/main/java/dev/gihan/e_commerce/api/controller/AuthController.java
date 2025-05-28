package dev.gihan.e_commerce.api.controller;

import dev.gihan.e_commerce.api.dto.requestDto.LoginRequestDto;
import dev.gihan.e_commerce.api.dto.responseDto.JwtResponseDto;
import dev.gihan.e_commerce.api.exception.UserNotFoundException;
import dev.gihan.e_commerce.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto loginRequest) throws UserNotFoundException {
        JwtResponseDto token = authService.authenticate(loginRequest);
        return ResponseEntity.ok(token);
    }
}

