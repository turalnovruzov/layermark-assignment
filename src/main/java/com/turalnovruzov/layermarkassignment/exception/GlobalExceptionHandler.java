package com.turalnovruzov.layermarkassignment.exception;

import com.turalnovruzov.layermarkassignment.payload.ErrorResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class, EmptyResultDataAccessException.class})
    public ErrorResponse resourceNotFoundException(HttpServletRequest request) {
        return new ErrorResponse(
                new Date(),
                HttpStatus.NOT_FOUND.value(),
                "Resource not found.",
                request.getRequestURI());
    }
}
