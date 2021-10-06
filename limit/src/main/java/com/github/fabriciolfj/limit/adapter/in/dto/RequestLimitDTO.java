package com.github.fabriciolfj.limit.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestLimitDTO {

    @NotEmpty(message = "Account not empty")
    private String account;
    @NotNull(message = "Balance not null")
    private BigDecimal balance;
}
