package cl.morsecode.cl.dto;

public class MainDTO {
    private String message;

    public MainDTO() {
    }

    public MainDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
