package com.github.fabriciolfj.business.usecase;

import com.github.fabriciolfj.business.FindLastExtract;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.domain.Extract;
import com.github.fabriciolfj.domain.exceptions.ExtractCreateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ExtractCreateCase {

    private final SaveExtract saveExtract;
    private final FindLastExtract findLastExtract;

    public void execute(final Extract extract, final String account) {
        try {
            final Extract last = findLastExtract.findLast(account);
            saveExtract.execute(extract.updateBalance(last), account);
            log.info("Successfully created extract");
        } catch (Exception e) {
            throw new ExtractCreateException("Failed to created extract. Details: " + e.getMessage());
        }
    }
}
