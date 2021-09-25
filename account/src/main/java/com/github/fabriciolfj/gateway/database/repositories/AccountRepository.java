package com.github.fabriciolfj.gateway.database.repositories;

import com.github.fabriciolfj.gateway.database.entities.AccountEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepository implements PanacheRepository<AccountEntity> {

}
