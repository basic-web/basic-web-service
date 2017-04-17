package com.github.ququzone.basicweb.common;

/**
 * Service exception.
 *
 * @author Yang XuePing
 */
public class ServiceException extends RuntimeException {
    private int statusCode = 500;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
