package com.meta.contato.gateway;

import com.meta.contato.controller.data.request.ContatoControllerCreateRequest;
import com.meta.contato.controller.data.response.ContatoControllerResponse;
import com.meta.contato.gateway.database.Contato;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ContatoGateway {
    Boolean createContato(ContatoControllerCreateRequest request) throws Exception;
    Page<Contato> listContatos(int page, int size);
    Optional<Contato> findContato(int idContato);
    Optional<Contato> updatedUser(ContatoControllerCreateRequest request, int idContato);
    Boolean deleteContato(int idContato);
}
