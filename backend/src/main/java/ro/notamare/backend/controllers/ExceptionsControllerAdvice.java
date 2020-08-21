package ro.notamare.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.notamare.backend.dtos.ExceptionOutput;
import ro.notamare.backend.exceptions.BusinessException;

@RestControllerAdvice
public class ExceptionsControllerAdvice {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ExceptionOutput handleBusinessExceptions(BusinessException e) {
        logger.info("Business exception, message = {}", e.getMessage(), e);
        return new ExceptionOutput(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionOutput handleBusinessExceptions(RuntimeException e) {
        logger.error("Runtime exception, message = {}", e.getMessage(), e);
        return new ExceptionOutput("Eroare interna");
    }
}
