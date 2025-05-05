package dev.gihan.e_commerce.api.exception;

public class ProductNotFoundExceptionException extends NotFoundException {

    public ProductNotFoundExceptionException(String message) {
        super(message);
    }

}
