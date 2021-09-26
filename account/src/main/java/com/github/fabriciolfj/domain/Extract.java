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
    private BigDecimal credit;
    private BigDecimal debit;
    private BigDecimal balance;
    private String describe;

    public Extract updateBalance(final Extract extract) {
        if (this.debit.compareTo(BigDecimal.ZERO) >= 1) {
            this.balance = extract.getBalance().subtract(this.debit);
            return this;
        }

        this.balance = extract.getBalance().add(this.credit);
        return this;
    }

    public static Extract init(final BigDecimal credit) {
        return Extract
                .builder()
                .credit(credit)
                .debit(BigDecimal.ZERO)
                .describe("Account creation")
                .balance(credit)
                .dataExtract(LocalDateTime.now())
                .build();
    }
}
