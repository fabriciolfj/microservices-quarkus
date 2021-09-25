package com.github.fabriciolfj.controller.mappers;

import com.github.fabriciolfj.controller.dto.AccountRequest;
import com.github.fabriciolfj.controller.dto.AccountResponse;
import com.github.fabriciolfj.domain.Account;
import com.github.fabriciolfj.domain.Extract;

import java.util.Arrays;
import java.util.UUID;

public class AccountDTOMapper {

    public AccountDTOMapper() { }

    public static final Account toDomain(final AccountRequest request) {
        return Account
                .builder()
                .code(UUID.randomUUID().toString())
                .customer(request.getCustomer())
                .extracts(Arrays.asList(Extract.init(request.getBalance())))
                .build();
    }

    public static final AccountResponse toResponse(final String code) {
        return AccountResponse
                .builder()
                .code(code)
                .build();
    }
}
