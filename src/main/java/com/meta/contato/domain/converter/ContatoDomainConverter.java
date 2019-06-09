package com.meta.contato.domain.converter;

import com.meta.contato.controller.data.request.ContatoControllerCreateRequest;
import com.meta.contato.controller.data.response.ContatoControllerCreate;
import com.meta.contato.controller.data.response.ContatoControllerResponse;
import com.meta.contato.gateway.database.Contato;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ContatoDomainConverter {
    Contato toDatabase(ContatoControllerCreateRequest request);
    ContatoControllerCreate domainCreateResponse(Boolean response);
    List<ContatoControllerResponse> domainListResponse(Page<Contato> contatos);
    ContatoControllerResponse domainFindContato(Optional<Contato> contato);

}
