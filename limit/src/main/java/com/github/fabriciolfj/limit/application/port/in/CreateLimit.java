package com.github.fabriciolfj.limit.application.port.in;

public interface CreateLimit {

    GetLimitCommand execute(CreateLimitCommand command);

}
