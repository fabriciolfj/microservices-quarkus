package com.github.fabriciolfj.gateway.providers.extract;

import com.github.fabriciolfj.business.FindExtract;
import com.github.fabriciolfj.business.FindLastExtract;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.domain.Account;
import com.github.fabriciolfj.domain.Extract;
import com.github.fabriciolfj.domain.exceptions.AccountNotFoundException;
import com.github.fabriciolfj.domain.exceptions.ExtractNotFoundException;
import com.github.fabriciolfj.gateway.database.entities.AccountEntity;
import com.github.fabriciolfj.gateway.database.repositories.AccountRepository;
import com.github.fabriciolfj.gateway.database.repositories.ExtractRepository;
import com.github.fabriciolfj.gateway.providers.account.AccountProvider;
import com.github.fabriciolfj.gateway.providers.account.mapper.AccountEntityMapper;
import com.github.fabriciolfj.gateway.providers.extract.mapper.ExtractEntityMapper;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class ExtractProvider implements SaveExtract, FindExtract, FindLastExtract {

    private final ExtractRepository extractRepository;
    private final AccountRepository accountRepository;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void execute(final Extract extract, final String account) {
        final var entity = ExtractEntityMapper.toEntity(extract, findByAccount(account));
        extractRepository.persist(entity);
    }

    @Override
    @Transactional(Transactional.TxType.NEVER)
    public List<Extract> find(final String account) {
        return extractRepository.find("account", account)
                .stream()
                .map(ExtractEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(Transactional.TxType.NEVER)
    public Extract findLast(final String account) {
        final AccountEntity accountEntity = findByAccount(account);
        return extractRepository
                .find("Select e from ExtractEntity e where e.dateExtract = (select max(t.dateExtract) from ExtractEntity t where t.account = ?1)",
                        accountEntity)
                .firstResultOptional()
                .map(ExtractEntityMapper::toDomain)
                .orElseThrow(() -> new ExtractNotFoundException("Extract not found by account: " + account));
    }

    private AccountEntity findByAccount(final String account) {
        return accountRepository.find("code", account)
                .firstResultOptional()
                .orElseThrow(() -> new AccountNotFoundException("Account not found, by code: " + account));
    }
}
