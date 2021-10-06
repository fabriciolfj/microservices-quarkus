package com.github.fabriciolfj.limit.domain;

import java.math.BigDecimal;

public class LimitBasic extends SeekLimit {

    private static final BigDecimal VALUE = BigDecimal.valueOf(1000);

    @Override
    protected boolean checkValue(final BigDecimal balance) {
        return balance.compareTo(VALUE) < 1;
    }

    @Override
    protected TypeLimit create() {
        return TypeLimit
                .builder()
                .dailyOperations(BigDecimal.valueOf(1999.00))
                .dailyWithdrawalAmount(10)
                .build();
    }

    @Override
    protected TypeLimit otherSeekLimit(final BigDecimal balance) {
        return new LimitIntermediary()
                .execute(balance);
    }
}
