package dev.gihan.e_commerce.api.exception;

import dev.gihan.e_commerce.api.dto.responseDto.ErrorResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdviser {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ErrorResponseDto handleNotFoundException(ChangeSetPersister.NotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setMessage(ex.getMessage());
        return errorResponseDto;
    }

}
