package com.github.fabriciolfj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Extract {

    private LocalDateTime dataExtract;
    private BigDecimal value;
    private BigDecimal balance;
    private String decribe;
}
