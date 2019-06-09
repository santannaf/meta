package com.meta.contato.gateway.impl;

import com.meta.contato.controller.data.request.ContatoControllerCreateRequest;
import com.meta.contato.controller.data.response.ContatoControllerResponse;
import com.meta.contato.domain.converter.ContatoDomainConverter;
import com.meta.contato.gateway.ContatoGateway;
import com.meta.contato.gateway.database.Contato;
import com.meta.contato.gateway.database.ContatoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ContatoGatewayImpl implements ContatoGateway {

    private final ContatoRepository repository;
    private final ContatoDomainConverter converter;

    @Override
    public Boolean createContato(ContatoControllerCreateRequest request) {
        try {
            repository.save(converter.toDatabase(request));

            return true;
        } catch (Exception error) {
            log.error("Não foi possível inserir um contato na tabela > " + error.getMessage());
            return false;
        }
    }

    @Override
    public Page<Contato> listContatos(int page, int size) {
        try {
            Pageable pagination = PageRequest.of(page, size);
            Page<Contato> contatos = repository.findAll(pagination);

            return contatos;
        } catch (Exception error) {
            log.error("Não foi possível listar os contatos > " + error.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Contato> findContato(int idContato) {
        try {
            Optional<Contato> contato = repository.findById(idContato);

            return contato;
        } catch (Exception error) {
            log.error("Não foi possível encontrar o contato > id " + idContato + " > " + error.getMessage());
            return null;
        }
    }

    @Override
    public Optional<Contato> updatedUser(ContatoControllerCreateRequest request, int idContato) {
        try {
            Optional<Contato> contato = repository.findById(idContato);

            if (contato == null) return null;

            return contato.map(item -> {
                item.setNome(request.getNome());
                item.setCanal(request.getCanal());
                item.setValor(request.getValor());
                item.setObs(request.getObs());

                Contato updated = repository.save(item);

                return updated;
            });
        } catch (Exception error) {
            log.error("Não foi possível atualizar o contato > id " + idContato + " > " + error.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteContato(int idContato) {
        try {
            Optional<Contato> contato = repository.findById(idContato);

            if (!contato.isPresent()) return false;

            repository.deleteById(idContato);

            return true;
        } catch (Exception error) {
            log.error("Não foi possível deletar o contato > id " + idContato + " > " + error.getMessage());
            return false;
        }
    }
}
