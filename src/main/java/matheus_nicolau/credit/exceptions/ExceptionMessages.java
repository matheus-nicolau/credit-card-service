package matheus_nicolau.credit.exceptions;

public enum ExceptionMessages {
    CREDIT_ALREADY_EXISTS("Credito já cadastrado"),
    PAYLOAD_NOT_FOUND("Payload não pode ser nulo"),
    BAD_SOLICITATION("Erro ao receber solicitação");
    

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
