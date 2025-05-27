package dev.gihan.e_commerce.api.controller;

import dev.gihan.e_commerce.api.dto.requestDto.UserRegisterDto;
import dev.gihan.e_commerce.api.dto.responseDto.UserDTO;
import dev.gihan.e_commerce.api.exception.UserAlreadyExistsException;
import dev.gihan.e_commerce.api.exception.UserNotFoundException;
import dev.gihan.e_commerce.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserRegisterDto dto) throws UserAlreadyExistsException {
        UserDTO created = userService.register(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }
}
