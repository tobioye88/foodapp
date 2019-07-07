package com.tobioyelami.foodapp.foodapp.restaurant.exceptions;

/**
 * Created by toyelami on 07/07/2019
 */
public class AppSericeException extends Exception {

    public AppSericeException() {
    }

    public AppSericeException(String message) {
        super(message);
    }

    public AppSericeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppSericeException(Throwable cause) {
        super(cause);
    }

    public AppSericeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
