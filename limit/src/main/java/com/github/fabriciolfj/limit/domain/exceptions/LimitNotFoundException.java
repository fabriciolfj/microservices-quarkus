package com.github.fabriciolfj.limit.domain.exceptions;

public class LimitNotFoundException extends RuntimeException {

    public LimitNotFoundException(final String msg) {
        super(msg);
    }
}
