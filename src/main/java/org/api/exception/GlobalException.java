package org.api.exception;

import org.api.DTOMetier.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalException {

    private String now() {
        return ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
    }

    @ExceptionHandler(MetricsException.class)
    public ResponseEntity<ErrorResponse> handleMetrics(MetricsException ex) {
        return ResponseEntity.status(500).body(
                new ErrorResponse(ex.getMessage(), 500, now())
        );
    }

}