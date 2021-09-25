package com.github.fabriciolfj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OperationDebit {

    private String account;
    private String describe;
    private BigDecimal value;
}
