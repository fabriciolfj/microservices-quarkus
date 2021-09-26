package com.github.fabriciolfj.controller.mappers;

import com.github.fabriciolfj.controller.dto.OperationCreditRequest;
import com.github.fabriciolfj.controller.dto.OperationDebitRequest;
import com.github.fabriciolfj.domain.Extract;
import com.github.fabriciolfj.domain.TypeOperation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExtractMapper {

    private ExtractMapper() { }

    public static final Extract toDomain(final BigDecimal value, final TypeOperation type) {
        return Extract
                .builder()
                .credit(type.equals(TypeOperation.CREDIT.getDescribe())? value : BigDecimal.ZERO)
                .debit(type.equals(TypeOperation.DEBIT.getDescribe())? value : BigDecimal.ZERO)
                .balance(BigDecimal.ZERO)
                .describe(type.equals(TypeOperation.CREDIT.getDescribe())? "Credit account" : "Debit account")
                .dataExtract(LocalDateTime.now())
                .build();
    }

    public static Extract createdDebit(final OperationDebitRequest operation) {
        return Extract
                .builder()
                .credit(BigDecimal.ZERO)
                .debit(operation.getValue())
                .dataExtract(LocalDateTime.now())
                .balance(BigDecimal.ZERO)
                .describe(operation.getDescribe())
                .build();
    }

    public static Extract createdCredit(final OperationCreditRequest operation) {
        return Extract
                .builder()
                .credit(operation.getValue())
                .debit(BigDecimal.ZERO)
                .dataExtract(LocalDateTime.now())
                .balance(BigDecimal.ZERO)
                .describe(operation.getDescribe())
                .build();
    }
}
