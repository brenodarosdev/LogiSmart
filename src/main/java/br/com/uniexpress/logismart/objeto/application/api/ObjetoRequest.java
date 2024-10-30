package br.com.uniexpress.logismart.objeto.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value
public class ObjetoRequest {
    @NotNull
    UUID idRemetente;
    @NotNull
    UUID idDestinatario;
    @NotBlank
    String descricao;
    @NotNull
    Double quilos;
}
