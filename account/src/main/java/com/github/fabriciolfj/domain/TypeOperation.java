package com.github.fabriciolfj.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeOperation {

    DEBIT("debit"), CREDIT("credit");

    private String describe;
}
