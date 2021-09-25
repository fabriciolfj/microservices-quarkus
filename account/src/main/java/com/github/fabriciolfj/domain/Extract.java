package com.github.fabriciolfj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Extract {

    private LocalDateTime dataExtract;
    private BigDecimal credit;
    private BigDecimal debit;
    private BigDecimal balance;
    private String describe;

    public static Extract init(final BigDecimal credit) {
        return Extract
                .builder()
                .credit(credit)
                .debit(BigDecimal.ZERO)
                .describe("Account creation")
                .dataExtract(LocalDateTime.now())
                .build();
    }

    public static Extract createdDebit(final OperationDebit operation, final BigDecimal balance) {
        return Extract
                .builder()
                .credit(BigDecimal.ZERO)
                .debit(operation.getValue())
                .dataExtract(LocalDateTime.now())
                .balance(balance.subtract(operation.getValue()))
                .describe(operation.getDescribe())
                .build();
    }

    public static Extract createdCredit(final OperationCredit operation, final BigDecimal balance) {
        return Extract
                .builder()
                .credit(operation.getValue())
                .debit(BigDecimal.ZERO)
                .dataExtract(LocalDateTime.now())
                .balance(balance.add(operation.getValue()))
                .describe(operation.getDescribe())
                .build();
    }
}
