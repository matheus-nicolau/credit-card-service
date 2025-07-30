package matheus_nicolau.credit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CreditNotFoundException.class)
    public ResponseEntity<ExceptionModel> creditNotFoundException(CreditNotFoundException clientException) {
        ExceptionModel exception = new ExceptionModel(clientException.getClass().getSimpleName(),
                                            clientException.getMessage(), ZonedDateTime.now(ZoneId.of("UTC")));
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(CreditAlreadyExistsException.class)
    public ResponseEntity<ExceptionModel> creditAlreadyExistsException(CreditAlreadyExistsException clientException) {
        ExceptionModel exception = new ExceptionModel(clientException.getClass().getSimpleName(),
                                            clientException.getMessage(), ZonedDateTime.now(ZoneId.of("UTC")));
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(exception);
    }

}
