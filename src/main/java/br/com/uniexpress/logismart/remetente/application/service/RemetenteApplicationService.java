package br.com.uniexpress.logismart.remetente.application.service;

import br.com.uniexpress.logismart.remetente.application.api.AlteraRemetenteRequest;
import br.com.uniexpress.logismart.remetente.application.api.NovoRemetenteResponse;
import br.com.uniexpress.logismart.remetente.application.api.RemetenteRequest;
import br.com.uniexpress.logismart.remetente.application.api.RemetenteResponse;
import br.com.uniexpress.logismart.remetente.infra.RemetenteRepository;
import br.com.uniexpress.logismart.remetente.domain.Remetente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    @Override
    public RemetenteResponse buscaRemetentePorId(UUID idRemetente) {
        log.debug("[start] RemetenteApplicationService - buscaRemetentePorId");
        Remetente remetente = remetenteRepository.buscaRemetentePorId(idRemetente);
        log.debug("[finish] RemetenteApplicationService - buscaRemetentePorId");
        return new RemetenteResponse(remetente);
    }

    @Override
    public void alteraRemetente(AlteraRemetenteRequest alteraRemetenteRequest, UUID idRemetente) {
        log.debug("[start] RemetenteApplicationService - alteraRemetente");
        Remetente remetente = remetenteRepository.buscaRemetentePorId(idRemetente);
        remetente.alteraRemetente(alteraRemetenteRequest);
        remetenteRepository.salvaRemetente(remetente);
        log.debug("[finish] RemetenteApplicationService - alteraRemetente");
    }

    @Override
    public void deletaRemetente(UUID idRemetente) {
        log.debug("[start] RemetenteApplicationService - deletaRemetente");
        remetenteRepository.buscaRemetentePorId(idRemetente);
        remetenteRepository.deletaRemetentePorId(idRemetente);
        log.debug("[finish] RemetenteApplicationService - deletaRemetente");
    }
}
