package br.com.uniexpress.logismart.remetente.application.api;

import br.com.uniexpress.logismart.remetente.application.service.RemetenteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class RemetenteController implements RemetenteAPI {
    private final RemetenteService remetenteService;

    @Override
    public NovoRemetenteResponse postNovoRemetente(RemetenteRequest novoRemetenteRequest) {
        log.debug("[start] RemetenteController - postNovoRemetente");
        NovoRemetenteResponse response = remetenteService.novoRemetente(novoRemetenteRequest);
        log.debug("[finish] RemetenteController - postNovoRemetente");
        return response;
    }

    @Override
    public RemetenteResponse getBuscaRemetentePorId(UUID idRemetente) {
        log.debug("[start] RemetenteController - getBuscaRemetentePorId");
        log.debug("[finish] RemetenteController - getBuscaRemetentePorId");
        return null;
    }
}
