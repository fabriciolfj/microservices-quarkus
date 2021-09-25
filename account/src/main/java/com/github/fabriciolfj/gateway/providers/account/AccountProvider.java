package com.github.fabriciolfj.gateway.providers.account;


import com.github.fabriciolfj.business.FindAccount;
import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.domain.Account;
import com.github.fabriciolfj.gateway.database.repositories.AccountRepository;
import com.github.fabriciolfj.gateway.providers.account.mapper.AccountEntityMapper;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

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
    public Account findByCode(String code) {
        return null;
    }

    @Override
    public List<Account> listAccounts() {
        return null;
    }
}
