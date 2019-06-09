package com.meta.contato.controller.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoControllerResponse {
    private Integer id;
    private String nome;
    private String canal;
    private String valor;
    private String obs;
}
