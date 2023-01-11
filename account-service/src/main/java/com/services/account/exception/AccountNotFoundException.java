package com.services.account.exception;


public class AccountNotFoundException extends  RuntimeException {
    String resourceName;
    String fieldName;
    String fieldValue;
    public AccountNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
