package com.github.fabriciolfj.limit.adapter.out.persistence.mapper;

import com.github.fabriciolfj.limit.adapter.out.persistence.entity.LimitEntity;
import com.github.fabriciolfj.limit.domain.Limit;

public class LimitEntityMapper {

    private LimitEntityMapper() { }

    public static LimitEntity toEntity(final Limit limit) {
        return LimitEntity
                .builder()
                .code(limit.getCode())
                .account(limit.getAccount())
                .dailyOperations(limit.getDailyOperations())
                .dailyWithdrawalAmount(limit.getDailyWithdrawalAmount())
                .build();
    }
}
