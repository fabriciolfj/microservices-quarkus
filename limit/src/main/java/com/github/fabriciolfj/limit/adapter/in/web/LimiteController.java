package com.github.fabriciolfj.limit.adapter.in.web;

import com.github.fabriciolfj.limit.adapter.in.dto.RequestLimitDTO;
import com.github.fabriciolfj.limit.adapter.in.mapper.CreateLimitMapper;
import com.github.fabriciolfj.limit.adapter.in.mapper.ResponseLimitMapper;
import com.github.fabriciolfj.limit.application.port.in.CreateLimit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/api/v1/limits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@ApplicationScoped
public class LimiteController {

    private final CreateLimit createLimit;

    @POST
    public Response createLimit(@Valid final RequestLimitDTO dto) {
        log.info("Request: {}", dto);

        final var command = createLimit.execute(CreateLimitMapper.toCommand(dto));

        log.info("Limite created success");

        return Response.accepted(ResponseLimitMapper.toDTO(command))
                .build();
    }
}
