package com.filesharing.exception;

/**
 * Custom exception for resource not found errors
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
