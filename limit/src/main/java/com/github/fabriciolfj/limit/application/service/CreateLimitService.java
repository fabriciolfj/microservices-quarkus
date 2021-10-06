package com.github.fabriciolfj.limit.application.service;

import com.github.fabriciolfj.limit.application.port.in.CreateLimit;
import com.github.fabriciolfj.limit.application.port.in.CreateLimitCommand;
import com.github.fabriciolfj.limit.application.port.in.GetLimitCommand;
import com.github.fabriciolfj.limit.application.port.in.mapper.GetLimitCommandMapper;
import com.github.fabriciolfj.limit.application.port.out.LimitSave;
import com.github.fabriciolfj.limit.domain.Limit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
class CreateLimitService implements CreateLimit {

    private final LimitSave limitSave;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public GetLimitCommand execute(final CreateLimitCommand command) {
        final var limit = Limit.create(command);
        log.info("Limit to account: {}", limit);

        limitSave.save(limit);

        return GetLimitCommandMapper.toCommand(limit);
    }

}
