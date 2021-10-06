package com.github.fabriciolfj.limit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TypeLimit {

    private BigDecimal dailyOperations;
    private int dailyWithdrawalAmount;
}
