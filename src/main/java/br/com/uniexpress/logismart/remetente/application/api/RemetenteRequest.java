package br.com.uniexpress.logismart.remetente.application.api;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class RemetenteRequest {
    @NotBlank
    String nome;
    // TODO Add validação para telefone
    @NotBlank
    @Column(unique = true)
    String telefone;
    @Email
    @NotBlank
    @Column(unique = true)
    String email;
    // TODO Add validação para CEP
    @NotBlank
    String CEP;
}
