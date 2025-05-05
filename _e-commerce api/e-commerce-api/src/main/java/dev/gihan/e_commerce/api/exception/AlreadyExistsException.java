package dev.gihan.e_commerce.api.exception;

public class AlreadyExistsException extends NotFoundException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
