package br.com.uniexpress.logismart.objeto.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @NotBlank
    private UUID idRemetente;
    @NotBlank
    private UUID idDestinatario;
    @NotNull
    private StausEnvio status;
    @NotNull
    private String descricao;
    @NotNull
    private Double peso;
    @NotNull
    private BigDecimal valorDoFrete;
    @NotBlank
    private String cepDeDestino;
}
