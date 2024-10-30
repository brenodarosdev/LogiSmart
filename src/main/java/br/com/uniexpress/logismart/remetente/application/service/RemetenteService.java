package br.com.uniexpress.logismart.remetente.application.service;

import br.com.uniexpress.logismart.remetente.application.api.NovoRemetenteResponse;
import br.com.uniexpress.logismart.remetente.application.api.RemetenteRequest;
import br.com.uniexpress.logismart.remetente.application.api.RemetenteResponse;

import java.util.UUID;

public interface RemetenteService {
    NovoRemetenteResponse novoRemetente(RemetenteRequest novoRemetenteRequest);
    RemetenteResponse buscaRemetentePorId(UUID idRemetente);
}
