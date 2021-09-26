package com.github.fabriciolfj.gateway.providers.extract.mapper;

import com.github.fabriciolfj.domain.Extract;
import com.github.fabriciolfj.gateway.database.entities.AccountEntity;
import com.github.fabriciolfj.gateway.database.entities.ExtractEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ExtractEntityMapper {

    private ExtractEntityMapper() { }

    public static final ExtractEntity toEntity(final Extract extract, final AccountEntity entity) {
        return ExtractEntity
                .builder()
                .describe(extract.getDescribe())
                .dateExtract(extract.getDataExtract())
                .debit(extract.getDebit())
                .credit(extract.getCredit())
                .balance(extract.getBalance())
                .account(entity)
                .build();
    }

    public static final List<ExtractEntity> toEntity(final List<Extract> extracts, final AccountEntity accountEntity) {
        return extracts
                .stream()
                .map(extract ->
                        ExtractEntity
                                .builder()
                                .account(accountEntity)
                                .dateExtract(extract.getDataExtract())
                                .balance(extract.getBalance())
                                .credit(extract.getCredit())
                                .debit(extract.getDebit())
                                .describe(extract.getDescribe())
                                .build())
                .collect(Collectors.toList());
    }

    public static final Extract toDomain(final ExtractEntity entity) {
        return Extract.builder()
                .balance(entity.getBalance())
                .dataExtract(entity.getDateExtract())
                .debit(entity.getDebit())
                .describe(entity.getDescribe())
                .credit(entity.getCredit())
                .build();
    }
}
