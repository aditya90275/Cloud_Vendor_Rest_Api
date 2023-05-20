package com.CloudVendorRestAPI.Exception;

public class CloudVendorFoundException extends RuntimeException {

    public CloudVendorFoundException(String message) {
        super(message);
    }

    public CloudVendorFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

