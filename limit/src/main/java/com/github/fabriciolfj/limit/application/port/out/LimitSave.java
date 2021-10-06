package com.github.fabriciolfj.limit.application.port.out;

import com.github.fabriciolfj.limit.domain.Limit;

public interface LimitSave {

    void save(final Limit limit);
}
