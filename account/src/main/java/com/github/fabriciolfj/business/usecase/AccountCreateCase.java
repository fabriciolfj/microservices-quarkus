package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.SaveAccount;
import com.github.fabriciolfj.domain.Account;
import com.github.fabriciolfj.domain.exceptions.AccountCreateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class AccountCreateCase {

    private final SaveAccount saveAccount;

    public String execute(final Account account) {
        try{
            saveAccount.execute(account);
            log.info("Account created successfully");
            return account.getCode();
        } catch (Exception e) {
            throw new AccountCreateException("Account creation failed. Details: " + e.getMessage());
        }
    }
}
