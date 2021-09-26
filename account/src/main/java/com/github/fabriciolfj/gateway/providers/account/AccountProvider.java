package com.github.fabriciolfj.gateway.providers.account;


import com.github.fabriciolfj.business.FindAccount;
import com.github.fabriciolfj.business.FindLastExtract;
import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.domain.Account;
import com.github.fabriciolfj.domain.Extract;
import com.github.fabriciolfj.domain.exceptions.AccountNotFoundException;
import com.github.fabriciolfj.gateway.database.repositories.AccountRepository;
import com.github.fabriciolfj.gateway.providers.account.mapper.AccountEntityMapper;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class AccountProvider implements SaveAccount, FindAccount {

    private final AccountRepository repository;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void execute(final Account account) {
        final var entity = AccountEntityMapper.toEntity(account);
        repository.persist(entity);
    }

    @Override
    @Transactional(Transactional.TxType.NEVER)
    public Account findByCode(String code) {
        return repository.find("code", code)
                .firstResultOptional()
                .map(AccountEntityMapper::toDomain)
                .orElseThrow(() -> new AccountNotFoundException("Acocunt not found by code? " + code));
    }

    @Override
    @Transactional(Transactional.TxType.NEVER)
    public List<Account> listAccounts() {
        return repository.findAll()
                .stream().map(AccountEntityMapper::toDomain)
                .collect(Collectors.toList());
    }
}
