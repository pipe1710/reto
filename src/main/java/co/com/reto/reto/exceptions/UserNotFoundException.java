package co.com.reto.reto.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
    super(message);
    }
}
