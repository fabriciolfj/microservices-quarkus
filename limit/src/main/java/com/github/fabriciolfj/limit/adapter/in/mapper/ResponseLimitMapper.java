package com.github.fabriciolfj.limit.adapter.in.mapper;

import com.github.fabriciolfj.limit.adapter.in.dto.ResponseLimitDTO;
import com.github.fabriciolfj.limit.application.port.in.GetLimitCommand;

public class ResponseLimitMapper {

    private ResponseLimitMapper() { }

    public static ResponseLimitDTO toDTO(final GetLimitCommand command) {
        return ResponseLimitDTO.builder()
                .code(command.getCode())
                .dailyOperations(command.getDailyOperations())
                .dailyWithdrawalAmount(command.getDailyWithdrawalAmount())
                .build();
    }
}
