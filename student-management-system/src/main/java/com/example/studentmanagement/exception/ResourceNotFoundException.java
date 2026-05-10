package com.example.studentmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown when a student is not found in the database.
 * @ResponseStatus(HttpStatus.NOT_FOUND) automatically returns 404 HTTP status.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor with a custom message.
     * @param message - description of what resource was not found
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
