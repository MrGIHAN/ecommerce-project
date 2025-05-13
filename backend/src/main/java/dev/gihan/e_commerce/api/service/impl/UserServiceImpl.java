package dev.gihan.e_commerce.api.service.impl;

import dev.gihan.e_commerce.api.dto.requestDto.UserRequestDto;
import dev.gihan.e_commerce.api.exception.AlreadyExistsException;
import dev.gihan.e_commerce.api.exception.EmptyException;
import dev.gihan.e_commerce.api.exception.NotFoundException;
import dev.gihan.e_commerce.api.model.User;
import dev.gihan.e_commerce.api.repository.UserRepository;
import dev.gihan.e_commerce.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User create(UserRequestDto userRequestDto) throws AlreadyExistsException, EmptyException {

        if (userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new AlreadyExistsException("Username already exists");
        }
        if ((userRequestDto.getPassword() == null || userRequestDto.getPassword().isEmpty())) {
            throw new EmptyException("Password cannot be empty");
        }
        if (userRepository.existsByUsername(userRequestDto.getUsername())) {
            throw new AlreadyExistsException("Username already exists");
        }

        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id) throws NotFoundException {
        return userRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("User Not Found" + id)
        );
    }

    @Override
    @Transactional
    public User update(Long id, UserRequestDto userRequestDto)throws NotFoundException{
        User user = getUserById(id);

        if (userRequestDto.getUsername() != null && !userRequestDto.getUsername().equals(user.getUsername())) {
            if (userRepository.existsByUsername(userRequestDto.getUsername())) {
                throw new AlreadyExistsException("Username already taken");
            }
            user.setUsername(userRequestDto.getUsername());
        }

        if (userRequestDto.getEmail() != null && !userRequestDto.getEmail().equals(user.getEmail())) {
            if (userRepository.existsByEmail(userRequestDto.getEmail())) {
                throw new AlreadyExistsException("Email already registered");
            }
            user.setEmail(userRequestDto.getEmail());
        }

        return userRepository.save(user);

    }

    @Override
    public void delete(Long id) {

    }
}
