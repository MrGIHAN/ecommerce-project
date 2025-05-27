package dev.gihan.e_commerce.api.service;

import dev.gihan.e_commerce.api.dto.responseDto.UserDTO;
import dev.gihan.e_commerce.api.dto.requestDto.UserRegisterDto;
import dev.gihan.e_commerce.api.exception.UserAlreadyExistsException;
import dev.gihan.e_commerce.api.exception.UserNotFoundException;

public interface UserService {

    UserDTO register(UserRegisterDto dto) throws UserAlreadyExistsException;
    UserDTO getUserByUsername(String username) throws UserNotFoundException;

}

