package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.responseDto.UserDTO;
import dev.gihan.e_commerce.api.dto.requestDto.UserRegisterDto;
import dev.gihan.e_commerce.api.exception.UserAlreadyExistsException;
import dev.gihan.e_commerce.api.exception.UserNotFoundException;
import dev.gihan.e_commerce.api.model.User;
import dev.gihan.e_commerce.api.model.option.Role;
import dev.gihan.e_commerce.api.repository.UserRepository;
import dev.gihan.e_commerce.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO register(UserRegisterDto dto) throws UserAlreadyExistsException {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("User with email already exists");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(Role.valueOf(dto.getRole().toUpperCase()));

        User savedUser = userRepository.save(user);

        System.out.println("✅ Registered with encoded password: " + encodedPassword);

        return toDTO(savedUser);
    }

    @Override
    public UserDTO getUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return toDTO(user);
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());
        return dto;
    }
}
