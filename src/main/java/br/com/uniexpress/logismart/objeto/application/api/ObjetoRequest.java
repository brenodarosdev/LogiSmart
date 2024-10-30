package br.com.uniexpress.logismart.objeto.application.api;

import lombok.Value;

import java.util.UUID;

@Value
public class ObjetoRequest {
    UUID idRemetente;
    UUID idDestinatario;
    String descricao;
    Double quilos;
}
