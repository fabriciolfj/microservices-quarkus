package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.Account;

import java.util.List;

public interface FindAccount {

    Account findByCode(final String code);

    List<Account> listAccounts();
}
