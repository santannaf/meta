package com.meta.contato.controller.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoControllerRequest {
    private String id;
    private String nome;
    private String canal;
    private String valor;
    private String obs;
}
