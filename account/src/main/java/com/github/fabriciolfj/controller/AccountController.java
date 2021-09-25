package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.usecase.AccountCreateCase;
import com.github.fabriciolfj.business.usecase.FindAccountCase;
import com.github.fabriciolfj.controller.dto.AccountRequest;
import com.github.fabriciolfj.controller.mappers.AccountDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;


@Slf4j
@Path("api/v1/accounts")
@ApplicationScoped
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

    private final AccountCreateCase createCase;
    private final FindAccountCase findAccountCase;

    @POST
    public Response created(final AccountRequest request) {
        final var account = AccountDTOMapper.toDomain(request);
        log.info("Account creation request {}", account);

        final var response = AccountDTOMapper.toResponse(createCase.execute(account));
        log.info("Account code created: {}", request);

        return Response
                .status(HttpStatus.SC_CREATED)
                .entity(response)
                .build();
    }

    @GET
    @Path("{code}")
    public Response findAccount(@PathParam("code") final String code) {
        final var account  = findAccountCase.findAccount(code);
        log.info("Account located: {}", code);

        var response = AccountDTOMapper.toResponse(account);
        return Response.accepted(account).build();
    }

    @GET
    public Response findAll() {
        final var accounts = findAccountCase.findAll();
        final var responses = accounts.stream()
                .map(AccountDTOMapper::toResponse)
                .collect(Collectors.toList());

        return Response
                .status(HttpStatus.SC_CREATED)
                .entity(responses)
                .build();
    }
}
