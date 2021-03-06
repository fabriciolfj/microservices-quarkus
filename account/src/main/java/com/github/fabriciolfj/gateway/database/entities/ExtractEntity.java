package com.github.fabriciolfj.gateway.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "extracts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExtractEntity {

    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_extract")
    @ToString.Include
    private LocalDateTime dateExtract;
    @ToString.Include
    private BigDecimal credit;
    @ToString.Include
    private BigDecimal debit;
    @ToString.Include
    private BigDecimal balance;
    @ToString.Include
    @Column(name = "description")
    private String describe;
    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;
}
