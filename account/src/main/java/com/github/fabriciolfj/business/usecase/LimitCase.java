package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.domain.Extract;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class LimitCase {

    private final ExtractCreateCase extractCreateCase;
    private final ChargeFeeCase chargeFeeCase;

    public void execute(final Extract extract, final String account) {

    }
}
