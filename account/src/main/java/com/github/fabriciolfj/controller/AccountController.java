package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.usecase.AccountCreateCase;
import com.github.fabriciolfj.controller.dto.AccountRequest;
import com.github.fabriciolfj.controller.mappers.AccountDTOMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Slf4j
@Path("api/v1/accounts")
@ApplicationScoped
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

    private final AccountCreateCase createCase;

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
}
