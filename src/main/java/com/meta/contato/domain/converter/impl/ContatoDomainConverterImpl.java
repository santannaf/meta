package com.meta.contato.domain.converter.impl;

import com.meta.contato.controller.data.request.ContatoControllerCreateRequest;
import com.meta.contato.controller.data.response.ContatoControllerCreate;
import com.meta.contato.controller.data.response.ContatoControllerResponse;
import com.meta.contato.domain.converter.ContatoDomainConverter;
import com.meta.contato.gateway.database.Contato;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ContatoDomainConverterImpl implements ContatoDomainConverter {
    @Override
    public Contato toDatabase(ContatoControllerCreateRequest request) {
        return Contato.builder()
                .nome(request.getNome())
                .canal(request.getCanal())
                .valor(request.getValor())
                .obs(request.getObs())
                .build();
    }

    @Override
    public ContatoControllerCreate domainCreateResponse(Boolean response) {
        return ContatoControllerCreate.builder()
                .created(response)
                .build();
    }

    @Override
    public List<ContatoControllerResponse> domainListResponse(Page<Contato> contatos) {
        List<ContatoControllerResponse> list = new ArrayList<>();
        contatos.forEach(item -> list.add(this.toContatoController(item)));

        return list;
    }

    @Override
    public ContatoControllerResponse domainFindContato(Optional<Contato> contato) {
        return ContatoControllerResponse.builder()
                .id(contato.get().getId())
                .nome(contato.get().getNome())
                .canal(contato.get().getCanal())
                .valor(contato.get().getValor())
                .obs(contato.get().getObs())
                .build();
    }

    private ContatoControllerResponse toContatoController(Contato contato) {
        return ContatoControllerResponse.builder()
                .id(contato.getId())
                .nome(contato.getNome())
                .canal(contato.getCanal())
                .valor(contato.getValor())
                .obs(contato.getObs())
                .build();
    }
}
