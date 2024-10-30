package br.com.uniexpress.logismart.remetente.application.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

@Value
public class AlteraRemetenteRequest {
    @NotBlank
    String nome;
    @NotBlank
    @Pattern(regexp = "^\\d{2}\\s?\\d{8,9}$", message = "O telefone deve ter o DDD seguido de 8 ou 9 dígitos")
    String telefone;
    @Email
    @NotBlank
    String email;
    @NotBlank
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "O CEP deve ter o formato 99999-999")
    String cep;
}
