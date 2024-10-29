package br.com.uniexpress.logismart.remetente.application.service;

import br.com.uniexpress.logismart.remetente.application.api.NovoRemetenteResponse;
import br.com.uniexpress.logismart.remetente.application.api.RemetenteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RemetenteApplicationService implements RemetenteService {
    @Override
    public NovoRemetenteResponse novoRemetente(RemetenteRequest novoRemetenteRequest) {
        log.debug("[start] RemetenteApplicationService - novoRemetente");
        log.debug("[finish] RemetenteApplicationService - novoRemetente");
        return null;
    }
}
