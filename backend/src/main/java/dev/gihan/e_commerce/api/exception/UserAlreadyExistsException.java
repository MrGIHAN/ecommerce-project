package dev.gihan.e_commerce.api.exception;

public class UserAlreadyExistsException extends NotFoundException{
  public UserAlreadyExistsException(String message) {
    super(message);
  }
}

