package com.meta.contato.gateway.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
