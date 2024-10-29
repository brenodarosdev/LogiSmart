package br.com.uniexpress.logismart.remetente.domain;

import br.com.uniexpress.logismart.remetente.application.api.RemetenteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Remetente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @NotBlank
    private String nome;
    @Pattern(regexp = "^\\d{2}\\s?\\d{8,9}$", message = "O telefone deve ter o DDD seguido de 8 ou 9 dígitos")
    @NotBlank
    @Column(unique = true)
    private String telefone;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "O CEP deve ter o formato 99999-999")
    @NotBlank
    private String cep;

    public Remetente(RemetenteRequest novoRemetenteRequest) {
        this.nome = novoRemetenteRequest.getNome();
        this.telefone = novoRemetenteRequest.getTelefone();
        this.email = novoRemetenteRequest.getEmail();
        this.cep = novoRemetenteRequest.getCep();
    }
}
