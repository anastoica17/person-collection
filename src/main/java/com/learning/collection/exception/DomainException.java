package com.learning.collection.exception;

public abstract class DomainException extends RuntimeException {

    DomainException() {
        super();
    }

    DomainException(String message) {
        super(message);
    }

    public abstract String getDetailedMessage();

}
