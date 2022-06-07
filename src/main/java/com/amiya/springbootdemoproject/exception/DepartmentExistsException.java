package com.amiya.springbootdemoproject.exception;

public class DepartmentExistsException extends RuntimeException {
    public DepartmentExistsException(String message) {
        super(message);
    }
}
