package com.github.fabriciolfj.limit.adapter.out.persistence;

import com.github.fabriciolfj.limit.adapter.out.persistence.entity.LimitEntity;
import com.github.fabriciolfj.limit.adapter.out.persistence.mapper.LimitEntityMapper;
import com.github.fabriciolfj.limit.application.port.out.LimitSave;
import com.github.fabriciolfj.limit.domain.Limit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class LimitRepositoryAdapter implements LimitSave {

    private final LimitRepository repository;

    @Override
    public void save(final Limit limit) {
        final var limitEntity = findByAccount(limit.getAccount());

        if (Objects.isNull(limitEntity)) {
            log.info("Save limit");
            repository.persist(LimitEntityMapper.toEntity(limit));
            return;
        }

        log.info("Update limit");
        repository.persist(limitEntity.updateEntity(limit));
    }

    private LimitEntity findByAccount(final String account) {
        return repository.find("account", account)
                .firstResult();
    }
}
