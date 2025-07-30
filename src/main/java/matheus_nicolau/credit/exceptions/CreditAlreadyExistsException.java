package matheus_nicolau.credit.exceptions;

public class CreditAlreadyExistsException extends RuntimeException {
    public CreditAlreadyExistsException(String message) {
        super(message);
    }
}
