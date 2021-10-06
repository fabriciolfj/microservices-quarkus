package com.github.fabriciolfj.limit.domain;

import com.github.fabriciolfj.limit.domain.exceptions.LimitNotFoundException;

import java.math.BigDecimal;

public class LimitAdvanced extends SeekLimit {

    @Override
    protected boolean checkValue(BigDecimal balance) {
        return true;
    }

    @Override
    protected TypeLimit create() {
        return TypeLimit
                .builder()
                .dailyOperations(BigDecimal.valueOf(9999.00))
                .dailyWithdrawalAmount(30)
                .build();
    }

    @Override
    protected TypeLimit otherSeekLimit(BigDecimal balance) {
        throw new LimitNotFoundException("Limit not found to balance: " + balance);
    }
}
