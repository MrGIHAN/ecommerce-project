package dev.gihan.e_commerce.api.exception;

public class AlreadyReviewedException extends NotFoundException {
    public AlreadyReviewedException(String message) {
        super(message);
    }
}

