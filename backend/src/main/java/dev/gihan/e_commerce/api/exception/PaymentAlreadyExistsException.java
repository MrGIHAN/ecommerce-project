package dev.gihan.e_commerce.api.exception;

public class PaymentAlreadyExistsException extends NotFoundException {
    public PaymentAlreadyExistsException(String message) {
        super(message);
    }
}

