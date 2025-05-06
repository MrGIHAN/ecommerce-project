package dev.gihan.e_commerce.api.service;


import dev.gihan.e_commerce.api.dto.requestDto.UserRequestDto;
import dev.gihan.e_commerce.api.exception.AlreadyExistsException;
import dev.gihan.e_commerce.api.exception.EmptyException;
import dev.gihan.e_commerce.api.exception.NotFoundException;
import dev.gihan.e_commerce.api.model.User;

public interface UserService {

    User create(UserRequestDto userRequestDto)throws AlreadyExistsException, EmptyException;
    User getUserById(long id)throws NotFoundException;
    User update (Long id, UserRequestDto userRequestDto)throws NotFoundException;
    void delete (Long id);

}
