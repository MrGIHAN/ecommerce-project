package dev.gihan.e_commerce.api.controller;

import dev.gihan.e_commerce.api.dto.requestDto.UserRequestDto;
import dev.gihan.e_commerce.api.exception.AlreadyExistsException;
import dev.gihan.e_commerce.api.exception.EmptyException;
import dev.gihan.e_commerce.api.exception.NotFoundException;
import dev.gihan.e_commerce.api.model.User;
import dev.gihan.e_commerce.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/create")
    public User create(@RequestBody UserRequestDto userRequestDto) throws EmptyException, AlreadyExistsException {
       return userService.create(userRequestDto);
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id,@RequestBody UserRequestDto userRequestDto) throws NotFoundException {
        return userService.update(id, userRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
