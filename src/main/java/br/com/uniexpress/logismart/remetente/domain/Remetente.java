package br.com.uniexpress.logismart.remetente.domain;

import br.com.uniexpress.logismart.remetente.application.api.RemetenteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

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

    public Remetente(RemetenteRequest novoRemetenteRequest) {
        this.nome = novoRemetenteRequest.getNome();
        this.cnpj = novoRemetenteRequest.getCnpj();
        this.telefone = novoRemetenteRequest.getTelefone();
        this.email = novoRemetenteRequest.getEmail();
        this.cep = novoRemetenteRequest.getCep();
    }

    public void alteraRemetente(RemetenteRequest alteraRemetenteRequest) {
        this.nome = alteraRemetenteRequest.getNome();
        this.telefone = alteraRemetenteRequest.getTelefone();
        this.email = alteraRemetenteRequest.getEmail();
        this.cep = alteraRemetenteRequest.getCep();
    }
}
