package com.github.fabriciolfj.limit.application.port.in.mapper;

import com.github.fabriciolfj.limit.application.port.in.GetLimitCommand;
import com.github.fabriciolfj.limit.domain.Limit;

public class GetLimitCommandMapper {

    private GetLimitCommandMapper() { }

    public static GetLimitCommand toCommand(final Limit limit) {
        return GetLimitCommand
                .builder()
                .code(limit.getCode())
                .build();
    }
}
