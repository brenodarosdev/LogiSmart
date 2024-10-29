package br.com.uniexpress.logismart.remetente.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class RemetenteController implements RemetenteAPI {
    @Override
    public NovoRemetenteResponse postNovoRemetente(RemetenteRequest novoRemetenteRequest) {
        log.debug("[start] RemetenteController - postNovoRemetente");
        log.debug("[finish] RemetenteController - postNovoRemetente");
        return null;
    }
}
