package com.github.fabriciolfj.limit.domain.mapper;

import com.github.fabriciolfj.limit.application.port.in.CreateLimitCommand;
import com.github.fabriciolfj.limit.domain.Limit;
import com.github.fabriciolfj.limit.domain.TypeLimit;

import java.util.UUID;

public class LimitMapper {

    private LimitMapper() { }

    public static Limit toDomain(final CreateLimitCommand command, final TypeLimit type) {
        return Limit
                .builder()
                .account(command.getAccount())
                .dailyWithdrawalAmount(type.getDailyWithdrawalAmount())
                .dailyOperations(type.getDailyOperations())
                .code(UUID.randomUUID().toString())
                .build();
    }
}
