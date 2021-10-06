package com.github.fabriciolfj.limit.adapter.out.persistence;

import com.github.fabriciolfj.limit.adapter.out.persistence.entity.LimitEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LimitRepository implements PanacheRepository<LimitEntity> {
}
