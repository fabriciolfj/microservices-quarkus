package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindAccount;
import com.github.fabriciolfj.domain.Account;
import com.github.fabriciolfj.domain.exceptions.AccountNotFoundException;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class FindAccountCase {

    private final FindAccount findAccount;

    public Account findAccount(final String code) {
        return findAccount.findByCode(code);
    }

    public List<Account> findAll() {
        final List<Account> accounts = findAccount.listAccounts();

        if (accounts.isEmpty()) {
            throw new AccountNotFoundException("Accounts not found");
        }

        return accounts;
    }
}
