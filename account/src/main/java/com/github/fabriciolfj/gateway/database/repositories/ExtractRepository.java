package com.github.fabriciolfj.gateway.database.repositories;

import com.github.fabriciolfj.gateway.database.entities.ExtractEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExtractRepository implements PanacheRepository<ExtractEntity> {
}
