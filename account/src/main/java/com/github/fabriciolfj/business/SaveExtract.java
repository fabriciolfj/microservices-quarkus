package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.Extract;

public interface SaveExtract {

    void execute(final Extract extract, final String account);
}
