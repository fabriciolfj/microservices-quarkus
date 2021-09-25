package com.github.fabriciolfj.business.usecase;

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

    public void execute(final Extract extract) {
        try {
            saveExtract.execute(extract);
            log.info("Successfully created extract");
        } catch (Exception e) {
            throw new ExtractCreateException("Failed to created extract. Details: " + e.getMessage());
        }
    }
}
