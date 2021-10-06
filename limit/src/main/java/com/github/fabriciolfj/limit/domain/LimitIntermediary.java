package com.github.fabriciolfj.limit.domain;

import java.math.BigDecimal;

public class LimitIntermediary extends SeekLimit {

    private static final BigDecimal VALUE = BigDecimal.valueOf(2000.00);

    @Override
    protected boolean checkValue(final BigDecimal balance) {
        return balance.compareTo(VALUE) < 1;
    }

    @Override
    protected TypeLimit create() {
        return TypeLimit
                .builder()
                .dailyOperations(BigDecimal.valueOf(2999.00))
                .dailyWithdrawalAmount(20)
                .build();
    }

    @Override
    protected TypeLimit otherSeekLimit(final BigDecimal balance) {
        return new LimitAdvanced()
                .execute(balance);
    }
}
