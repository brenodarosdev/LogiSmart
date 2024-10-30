package br.com.uniexpress.logismart.remetente.application.api;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Value;
import org.hibernate.validator.constraints.br.CNPJ;

@Value
public class RemetenteRequest {
    @NotBlank
    private String nome;
    @CNPJ
    @NotBlank
    @Column(unique = true)
    private String cnpj;
    @NotBlank
    @Pattern(regexp = "^\\d{2}\\s?\\d{8,9}$", message = "O telefone deve ter o DDD seguido de 8 ou 9 dígitos")
    private String telefone;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "O CEP deve ter o formato 99999-999")
    private String cep;
}
