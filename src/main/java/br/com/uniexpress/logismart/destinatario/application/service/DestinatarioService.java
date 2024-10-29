package br.com.uniexpress.logismart.destinatario.application.service;

import br.com.uniexpress.logismart.destinatario.application.api.DestinatarioRequest;
import br.com.uniexpress.logismart.destinatario.application.api.DestinatarioResponse;
import br.com.uniexpress.logismart.destinatario.application.api.NovoDestinatarioResponse;

import java.util.UUID;

public interface DestinatarioService {
    NovoDestinatarioResponse novoDestinatario(DestinatarioRequest novoDestinatarioRequest);
    DestinatarioResponse buscaDestinatarioPorId(UUID idDestinatario);
    void alteraDestinatario(DestinatarioRequest alteraDestinatarioRequest, UUID idDestinatario);
    void deletaDestinatario(UUID idDestinatario);
}
