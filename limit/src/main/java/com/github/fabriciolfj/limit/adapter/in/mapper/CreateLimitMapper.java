package com.github.fabriciolfj.limit.adapter.in.mapper;

import com.github.fabriciolfj.limit.adapter.in.dto.RequestLimitDTO;
import com.github.fabriciolfj.limit.application.port.in.CreateLimitCommand;

public class CreateLimitMapper {

    private CreateLimitMapper() { }

    public static CreateLimitCommand toCommand(final RequestLimitDTO dto) {
        return CreateLimitCommand
                .builder()
                .balance(dto.getBalance())
                .account(dto.getAccount())
                .build();
    }
}
