package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.Extract;

public interface FindByCodeExtract {

    Extract execute(final String code);
}
