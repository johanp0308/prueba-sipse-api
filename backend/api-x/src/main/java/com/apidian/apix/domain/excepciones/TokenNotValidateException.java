package com.apidian.apix.domain.excepciones;

public class TokenNotValidateException extends RuntimeException {
    public TokenNotValidateException(String message){
        super(message);
    }
}
