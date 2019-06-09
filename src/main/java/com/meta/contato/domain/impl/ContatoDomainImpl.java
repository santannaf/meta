package com.meta.contato.domain.impl;

import com.meta.contato.controller.data.request.ContatoControllerCreateRequest;
import com.meta.contato.controller.data.response.ContatoControllerCreate;
import com.meta.contato.controller.data.response.ContatoControllerResponse;
import com.meta.contato.domain.ContatoDomain;
import com.meta.contato.domain.converter.ContatoDomainConverter;
import com.meta.contato.gateway.ContatoGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class ContatoDomainImpl implements ContatoDomain {

    private final ContatoGateway gateway;
    private final ContatoDomainConverter converter;

    @Override
    public ContatoControllerCreate createUser(ContatoControllerCreateRequest request) throws Exception {
        try {
            Boolean response = gateway.createContato(request);

            return converter.domainCreateResponse(response);
        } catch (Exception error) {
            log.error("Erro ao inserir contato > " + error.getMessage());
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public List<ContatoControllerResponse> listContatos(int page, int size) throws Exception {
        try {
            List<ContatoControllerResponse> response = converter.domainListResponse(gateway.listContatos(page, size));

            return response;
        } catch (Exception error) {
            log.error("Erro ao listar contatos > " + error.getMessage());
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public ContatoControllerResponse contato(int idContato) throws Exception {
        try {
            ContatoControllerResponse response = converter.domainFindContato(gateway.findContato(idContato));

            return response;
        } catch (Exception error) {
            log.error("Erro ao encontrar contato > " + error.getMessage());
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public ContatoControllerResponse updatedUser(ContatoControllerCreateRequest request, int idContato) throws Exception {
        try {
            ContatoControllerResponse response = converter.domainFindContato(gateway.updatedUser(request, idContato));

            return response;
        } catch (Exception error) {
            log.error("Erro ao encontrar contato > " + error.getMessage());
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public Boolean deleteContato(int idContato) throws Exception {
        try {
            Boolean response = gateway.deleteContato(idContato);

            return response;
        } catch (Exception error) {
            log.error("Erro ao deletar contato > " + error.getMessage());
            throw new Exception(error.getMessage());
        }
    }
}
