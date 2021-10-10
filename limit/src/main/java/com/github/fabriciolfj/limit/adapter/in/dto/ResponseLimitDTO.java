package com.github.fabriciolfj.limit.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseLimitDTO {

    private String code;
    @JsonProperty("daily_operations")
    private BigDecimal dailyOperations;
    @JsonProperty("daily_withdrawal_amount")
    private int dailyWithdrawalAmount;
}
