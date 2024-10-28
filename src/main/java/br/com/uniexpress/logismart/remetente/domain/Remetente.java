package br.com.uniexpress.logismart.remetente.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    // TODO Add validação para telefone
    @NotBlank
    @Column(unique = true)
    private String telefone;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    // TODO Add validação para CEP
    @NotBlank
    private String CEP;

    public Remetente(String nome, String telefone, String email, String CEP) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.CEP = CEP;
    }
}