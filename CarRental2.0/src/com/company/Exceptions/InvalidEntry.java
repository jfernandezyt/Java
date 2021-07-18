package com.company.Exceptions;

public class InvalidEntry  extends Exception{

    public InvalidEntry() {
    }

    public InvalidEntry(String message) {
        super(message);
    }

    public InvalidEntry(Throwable cause) {
        super(cause);
    }
}
