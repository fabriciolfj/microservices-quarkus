package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.usecase.ExtractCreateCase;
import com.github.fabriciolfj.business.usecase.LimitCase;
import com.github.fabriciolfj.controller.dto.OperationCreditRequest;
import com.github.fabriciolfj.controller.dto.OperationDebitRequest;
import com.github.fabriciolfj.controller.mappers.ExtractMapper;
import com.github.fabriciolfj.domain.Extract;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Slf4j
@Path("api/v1/extracts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class ExtractController {

    private final ExtractCreateCase createCase;
    private final LimitCase limitCase;

    @PUT
    @Path("debit")
    public Response createDebit(final OperationDebitRequest debit) {
        final Extract extract = ExtractMapper.createdDebit(debit);
        log.info("Extract debit request: {}", extract.toString());

        limitCase.execute(extract, debit.getAccount());
        return Response.accepted()
                .build();
    }

    @PUT
    @Path("credit")
    public Response createCredit(final OperationCreditRequest credit) {
        final Extract extract = ExtractMapper.createdCredit(credit);
        log.info("Extract credit request: {}", extract.toString());

        createCase.execute(extract, credit.getAccount());
        return Response.accepted()
                .build();
    }
}
