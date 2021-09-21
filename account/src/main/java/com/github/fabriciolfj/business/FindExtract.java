package com.github.fabriciolfj.business;

import com.github.fabriciolfj.domain.Extract;

import java.util.List;

public interface FindExtract {

    List<Extract> find(final String account);
}
