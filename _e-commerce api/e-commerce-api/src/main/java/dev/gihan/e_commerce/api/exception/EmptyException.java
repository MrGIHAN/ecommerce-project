package dev.gihan.e_commerce.api.exception;

public class EmptyException extends NotFoundException {

    public EmptyException(String message) {
        super(message);
    }

}
