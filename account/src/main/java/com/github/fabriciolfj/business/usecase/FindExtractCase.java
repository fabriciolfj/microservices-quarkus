package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindExtract;
import com.github.fabriciolfj.domain.Extract;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class FindExtractCase {

    private final FindExtract findExtract;

    public List<Extract> execute(final String account) {
        return findExtract.find(account);
    }
}
