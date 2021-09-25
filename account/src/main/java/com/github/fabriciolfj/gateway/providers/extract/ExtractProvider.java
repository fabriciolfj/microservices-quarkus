package com.github.fabriciolfj.gateway.providers.extract;

import com.github.fabriciolfj.business.FindByCodeExtract;
import com.github.fabriciolfj.business.FindExtract;
import com.github.fabriciolfj.business.SaveExtract;
import com.github.fabriciolfj.domain.Extract;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ExtractProvider implements SaveExtract, FindByCodeExtract, FindExtract {

    @Override
    public Extract execute(final String code) {
        return null;
    }

    @Override
    public void execute(final Extract extract) {

    }

    @Override
    public List<Extract> find(final String account) {
        return null;
    }
}
