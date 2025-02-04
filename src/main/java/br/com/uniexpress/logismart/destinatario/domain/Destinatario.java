package br.com.uniexpress.logismart.destinatario.domain;

import br.com.uniexpress.logismart.destinatario.application.api.DestinatarioRequest;
import br.com.uniexpress.logismart.util.NormalizerUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Destinatario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "^\\d{2}\\s?\\d{8,9}$", message = "O telefone deve ter o DDD seguido de 8 ou 9 dígitos")
    private String telefone;
    @NotBlank
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "O CEP deve ter o formato 99999-999")
    private String cep;

    public Destinatario(DestinatarioRequest novoDestinatarioRequest) {
        this.nome = novoDestinatarioRequest.getNome();
        this.telefone = NormalizerUtil.normalizar(novoDestinatarioRequest.getTelefone());
        this.cep = NormalizerUtil.normalizar(novoDestinatarioRequest.getCep());
    }

    public void alteraDestinatario(DestinatarioRequest alteraDestinatarioRequest) {
        this.nome = alteraDestinatarioRequest.getNome();
        this.telefone = NormalizerUtil.normalizar(alteraDestinatarioRequest.getTelefone());
        this.cep = NormalizerUtil.normalizar(alteraDestinatarioRequest.getCep());
    }
}
