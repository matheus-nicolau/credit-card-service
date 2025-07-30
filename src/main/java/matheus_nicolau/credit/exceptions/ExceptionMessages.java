package matheus_nicolau.credit.exceptions;

public enum ExceptionMessages {
    CREDIT_NOT_FOUND("Credito não encontrado");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
