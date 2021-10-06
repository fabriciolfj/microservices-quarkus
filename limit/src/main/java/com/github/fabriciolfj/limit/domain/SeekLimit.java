package com.github.fabriciolfj.limit.domain;

import java.math.BigDecimal;

abstract class SeekLimit {

    public TypeLimit execute(final BigDecimal balance) {
        if (checkValue(balance)) {
            return create();
        }

        return otherSeekLimit(balance);
    }

    protected abstract boolean checkValue(final BigDecimal balance);
    protected abstract TypeLimit create();
    protected abstract TypeLimit otherSeekLimit(final BigDecimal balance);
}
