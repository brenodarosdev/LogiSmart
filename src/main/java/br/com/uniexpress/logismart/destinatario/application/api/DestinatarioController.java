package br.com.uniexpress.logismart.destinatario.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class DestinatarioController implements DestinatarioAPI {
    @Override
    public NovoDestinatarioResponse postNovoDestinatario(DestinatarioRequest novoDestinatarioRequest) {
        log.debug("[start] DestinatarioController - postNovoDestinatario");
        log.debug("[finish] DestinatarioController - postNovoDestinatario");
        return null;
    }
}
