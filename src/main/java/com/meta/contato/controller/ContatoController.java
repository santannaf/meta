package com.meta.contato.controller;

import com.meta.contato.controller.data.request.ContatoControllerCreateRequest;
import com.meta.contato.controller.data.response.ContatoControllerCreate;
import com.meta.contato.controller.data.response.ContatoControllerResponse;
import com.meta.contato.controller.data.response.ContatoControllerUpdated;
import com.meta.contato.domain.ContatoDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ContatoController {

    private final ContatoDomain domain;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/")
    public ResponseEntity<List<ContatoControllerResponse>> listContatos(@RequestParam int page, @RequestParam int size) throws Exception {
        try {
            List<ContatoControllerResponse> response = domain.listContatos(page, size);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception error) {
            log.error("Erro ao listar os contatos verifique > " + error.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao listar contatos > " + error.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/")
    public ResponseEntity<ContatoControllerCreate> createContato(@Valid @RequestBody ContatoControllerCreateRequest request) throws Exception {
        try {
            ContatoControllerCreate response = domain.createUser(request);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception error) {
            log.error("Erro ao criar um contato > " + error.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contato não foi criado > " + error.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{idContato}")
    public ResponseEntity<ContatoControllerResponse> contato (@PathVariable int idContato) throws Exception {
        try {
            ContatoControllerResponse response = domain.contato(idContato);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception error) {
            log.error("Erro ao pegar o contato id > " + idContato + " > " + error.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado > " + idContato);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{idContato}")
    public ResponseEntity<ContatoControllerResponse> updatedContato (@PathVariable int idContato, @RequestBody ContatoControllerCreateRequest request) throws Exception {
        try {
            ContatoControllerResponse response = domain.updatedUser(request, idContato);

            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (Exception error) {
            log.error("Erro ao pegar o contato id > " + idContato + " > " + error.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado > " + idContato);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{idContato}")
    public ResponseEntity<Boolean> deleteContato (@PathVariable int idContato) throws Exception {
        try {
            Boolean response = domain.deleteContato(idContato);

            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (Exception error) {
            log.error("Erro ao pegar o contato id > " + idContato + " > " + error.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado para deletar > " + idContato);
        }
    }







}
