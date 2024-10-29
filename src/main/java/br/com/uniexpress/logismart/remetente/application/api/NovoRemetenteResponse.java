package br.com.uniexpress.logismart.remetente.application.api;

import br.com.uniexpress.logismart.remetente.domain.Remetente;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class NovoRemetenteResponse {
    private UUID idRemetente;

    public NovoRemetenteResponse(Remetente remetente) {
        this.idRemetente = remetente.getId();
    }
}
