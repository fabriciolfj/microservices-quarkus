package com.github.fabriciolfj.gateway.providers.account.mapper;

import com.github.fabriciolfj.domain.Account;
import com.github.fabriciolfj.gateway.database.entities.AccountEntity;
import com.github.fabriciolfj.gateway.providers.extract.mapper.ExtractEntityMapper;

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
}
