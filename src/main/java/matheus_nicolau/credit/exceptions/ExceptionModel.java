package matheus_nicolau.credit.exceptions;

import java.time.ZonedDateTime;

public record ExceptionModel(
        String className,
        String message,
        ZonedDateTime timestamp
) { }
