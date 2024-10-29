package br.com.uniexpress.logismart.destinatario.application.api;

import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class DestinatarioResponse {
    private UUID id;
    private String nome;
    private String telefone;
    private String cep;

    public DestinatarioResponse(Destinatario destinatario) {
        this.id = destinatario.getId();
        this.nome = destinatario.getNome();
        this.telefone = destinatario.getTelefone();
        this.cep = destinatario.getCep();
    }
}
