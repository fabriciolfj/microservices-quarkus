package com.github.fabriciolfj.gateway.database.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExtractEntity extends PanacheEntityBase {

    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_extract")
    @ToString.Include
    private LocalDateTime dataExtract;
    @ToString.Include
    private BigDecimal credit;
    @ToString.Include
    private BigDecimal debit;
    @ToString.Include
    private BigDecimal balance;
    @ToString.Include
    private String describe;
    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;
}
