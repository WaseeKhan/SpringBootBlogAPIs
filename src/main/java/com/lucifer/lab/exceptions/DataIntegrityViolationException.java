package com.lucifer.lab.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    String resourceName;
    String fieldName;
    long fieldValue;


    public DataIntegrityViolationException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s Duplicate  %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
