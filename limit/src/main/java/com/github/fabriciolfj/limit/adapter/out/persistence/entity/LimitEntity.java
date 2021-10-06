package com.github.fabriciolfj.limit.adapter.out.persistence.entity;

import com.github.fabriciolfj.limit.domain.Limit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "limits")
@Entity
public class LimitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    @Column(name = "daily_operations")
    private BigDecimal dailyOperations;
    @Column(name = "daily_withdrawal_amount")
    private int dailyWithdrawalAmount;
    private String code;

    public LimitEntity updateEntity(final Limit limit) {
        this.dailyOperations = limit.getDailyOperations();
        this.dailyWithdrawalAmount = limit.getDailyWithdrawalAmount();

        return this;
    }
}
