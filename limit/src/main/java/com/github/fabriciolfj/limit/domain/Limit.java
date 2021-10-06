package com.github.fabriciolfj.limit.domain;

import com.github.fabriciolfj.limit.application.port.in.CreateLimitCommand;
import com.github.fabriciolfj.limit.domain.mapper.LimitMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Limit {

    private String account;
    private BigDecimal dailyOperations;
    private int dailyWithdrawalAmount;
    private String code;

    public static Limit create(final CreateLimitCommand command) {
        final var type = findType(command.getBalance());
        log.info("Type find: {}", type);

        return LimitMapper.toDomain(command, type);
    }

    private static TypeLimit findType(final BigDecimal balance) {
        final var type = new LimitBasic();
        return type.execute(balance);
    }

}
