package com.meta.contato.controller.data.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContatoControllerCreateRequest {
    @NotBlank
    @NotNull
    @NotEmpty
    private String nome;
    @NotBlank
    @NotNull
    @NotEmpty
    private String canal;
    @NotBlank
    @NotNull
    @NotEmpty
    private String valor;
    private String obs;
}
