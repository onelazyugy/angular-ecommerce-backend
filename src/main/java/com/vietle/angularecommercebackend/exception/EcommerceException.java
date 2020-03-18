package com.vietle.angularecommercebackend.exception;

public class EcommerceException extends Exception {
    private String message;
    private int statusCd;

    public EcommerceException() {
        super();
    }

    public EcommerceException(String message, int statusCd) {
        super(message);
        this.message = message;
        this.statusCd = statusCd;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(int statusCd) {
        this.statusCd = statusCd;
    }
}