package com.github.fabriciolfj.gateway.providers.account.mapper;

import com.github.fabriciolfj.domain.Account;
import com.github.fabriciolfj.domain.Extract;
import com.github.fabriciolfj.gateway.database.entities.AccountEntity;
import com.github.fabriciolfj.gateway.database.entities.ExtractEntity;
import com.github.fabriciolfj.gateway.providers.extract.mapper.ExtractEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

public class AccountEntityMapper {

    public AccountEntityMapper() { }

    public static final AccountEntity toEntity(final Account account) {
        final var entity = AccountEntity
                .builder()
                .code(account.getCode())
                .customer(account.getCustomer())
                .build();

        entity.setExtracts(ExtractEntityMapper.toEntity(account.getExtracts(), entity));
        return entity;
    }

    public static final Account toDomain(final AccountEntity accountEntity) {
        return Account
                .builder()
                .customer(accountEntity.getCustomer())
                .code(accountEntity.getCode())
                .extracts(toDomainExtract(accountEntity.getExtracts()))
                .build();
    }

    private static List<Extract> toDomainExtract(final List<ExtractEntity> extractEntities) {
        return extractEntities
                .stream()
                .map(ExtractEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
