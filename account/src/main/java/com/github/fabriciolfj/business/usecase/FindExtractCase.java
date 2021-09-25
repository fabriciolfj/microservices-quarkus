package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindByCodeExtract;
import com.github.fabriciolfj.business.FindExtract;
import com.github.fabriciolfj.domain.Extract;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class FindExtractCase {

    private final FindExtract findExtract;
    private final FindByCodeExtract findByCode;

    public List<Extract> execute(final String account) {
        return findExtract.find(account);
    }

    public Extract executeFinByCode(final String code) {
        return findByCode.execute(code);
    }
}
