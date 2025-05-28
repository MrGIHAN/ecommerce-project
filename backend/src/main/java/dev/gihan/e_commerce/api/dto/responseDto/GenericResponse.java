package dev.gihan.e_commerce.api.dto.responseDto;



public class GenericResponse<T> {
    private String message;
    private T data;

    public GenericResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    // Getters and setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}


