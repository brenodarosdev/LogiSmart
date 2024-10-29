package br.com.uniexpress.logismart.destinatario.application.api;

import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class NovoDestinatarioResponse {
    private UUID idDestinatario;
    public NovoDestinatarioResponse(Destinatario destinatario) {
        this.idDestinatario = destinatario.getId();
    }
}
