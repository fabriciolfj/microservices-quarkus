package com.github.fabriciolfj.limit.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetLimitCommand {

    private String code;
    private BigDecimal dailyOperations;
    private int dailyWithdrawalAmount;
}
