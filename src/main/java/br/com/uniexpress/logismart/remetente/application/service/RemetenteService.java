package br.com.uniexpress.logismart.remetente.application.service;

import br.com.uniexpress.logismart.remetente.application.api.NovoRemetenteResponse;
import br.com.uniexpress.logismart.remetente.application.api.RemetenteRequest;

public interface RemetenteService {
    NovoRemetenteResponse novoRemetente(RemetenteRequest novoRemetenteRequest);
}
