package com.meta.contato.domain;

import com.meta.contato.controller.data.request.ContatoControllerCreateRequest;
import com.meta.contato.controller.data.response.ContatoControllerCreate;
import com.meta.contato.controller.data.response.ContatoControllerResponse;
import com.meta.contato.controller.data.response.ContatoControllerUpdated;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContatoDomain {

    ContatoControllerCreate createUser(ContatoControllerCreateRequest request) throws Exception;
    List<ContatoControllerResponse> listContatos(int page, int size) throws Exception;
    ContatoControllerResponse contato(int idContato) throws Exception;
    ContatoControllerResponse updatedUser(ContatoControllerCreateRequest request, int idContato) throws Exception;
    Boolean deleteContato(int idContato) throws Exception;

}
