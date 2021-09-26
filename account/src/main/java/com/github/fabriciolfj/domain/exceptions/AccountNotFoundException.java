package com.github.fabriciolfj.domain.exceptions;

public class AccountNotFoundException extends BusinessException {

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
