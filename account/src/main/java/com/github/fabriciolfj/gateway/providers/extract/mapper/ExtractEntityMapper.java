package com.github.fabriciolfj.gateway.providers.extract.mapper;

import com.github.fabriciolfj.domain.Extract;
import com.github.fabriciolfj.gateway.database.entities.AccountEntity;
import com.github.fabriciolfj.gateway.database.entities.ExtractEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ExtractEntityMapper {

    private ExtractEntityMapper() {
    }

    public static final List<ExtractEntity> toEntity(final List<Extract> extracts, final AccountEntity accountEntity) {
        return extracts
                .stream()
                .map(extract ->
                        ExtractEntity
                                .builder()
                                .account(accountEntity)
                                .dataExtract(extract.getDataExtract())
                                .balance(extract.getBalance())
                                .credit(extract.getCredit())
                                .debit(extract.getDebit())
                                .describe(extract.getDescribe())
                                .build())
                .collect(Collectors.toList());
    }
}
