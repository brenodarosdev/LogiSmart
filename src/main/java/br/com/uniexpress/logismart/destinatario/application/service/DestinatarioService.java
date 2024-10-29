package br.com.uniexpress.logismart.destinatario.application.service;

import br.com.uniexpress.logismart.destinatario.application.api.DestinatarioRequest;
import br.com.uniexpress.logismart.destinatario.application.api.NovoDestinatarioResponse;

public interface DestinatarioService {
    NovoDestinatarioResponse novoDestinatario(DestinatarioRequest novoDestinatarioRequest);
}
