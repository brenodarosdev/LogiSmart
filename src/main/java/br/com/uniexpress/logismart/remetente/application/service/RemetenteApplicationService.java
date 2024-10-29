package br.com.uniexpress.logismart.remetente.application.service;

import br.com.uniexpress.logismart.remetente.application.api.NovoRemetenteResponse;
import br.com.uniexpress.logismart.remetente.application.api.RemetenteRequest;
import br.com.uniexpress.logismart.remetente.infra.RemetenteRepository;
import br.com.uniexpress.logismart.remetente.domain.Remetente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class RemetenteApplicationService implements RemetenteService {
    private final RemetenteRepository remetenteRepository;

    @Override
    public NovoRemetenteResponse novoRemetente(RemetenteRequest novoRemetenteRequest) {
        log.debug("[start] RemetenteApplicationService - novoRemetente");
         Remetente remetente = new Remetente(novoRemetenteRequest);
         remetenteRepository.salvaRemetente(remetente);
        log.debug("[finish] RemetenteApplicationService - novoRemetente");
        return new NovoRemetenteResponse(remetente);
    }
}
