package br.com.uniexpress.logismart.remetente.application.api;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

@Value
public class RemetenteRequest {
    @NotBlank
    String nome;
    @Pattern(regexp = "^\\d{2}\\s?\\d{8,9}$", message = "O telefone deve ter o DDD seguido de 8 ou 9 dígitos")
    @NotBlank
    @Column(unique = true)
    String telefone;
    @Email
    @NotBlank
    @Column(unique = true)
    String email;
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "O CEP deve ter o formato 99999-999")
    @NotBlank
    String cep;
}
