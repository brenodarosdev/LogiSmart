package br.com.uniexpress.logismart.destinatario.application.service;

import br.com.uniexpress.logismart.destinatario.application.api.DestinatarioRequest;
import br.com.uniexpress.logismart.destinatario.application.api.NovoDestinatarioResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class DestinatarioApplicationService implements DestinatarioService {
    @Override
    public NovoDestinatarioResponse novoDestinatario(DestinatarioRequest novoDestinatarioRequest) {
        log.debug("[start] DestinatarioApplicationService - novoDestinatario");
        log.debug("[finish] DestinatarioApplicationService - novoDestinatario");
        return null;
    }
}
