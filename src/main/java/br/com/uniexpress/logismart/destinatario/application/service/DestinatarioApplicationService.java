package br.com.uniexpress.logismart.destinatario.application.service;

import br.com.uniexpress.logismart.destinatario.application.api.DestinatarioRequest;
import br.com.uniexpress.logismart.destinatario.application.api.DestinatarioResponse;
import br.com.uniexpress.logismart.destinatario.application.api.NovoDestinatarioResponse;
import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import br.com.uniexpress.logismart.destinatario.infra.DestinatarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class DestinatarioApplicationService implements DestinatarioService {
    private final DestinatarioRepository destinatarioRepository;

    @Override
    public NovoDestinatarioResponse novoDestinatario(DestinatarioRequest novoDestinatarioRequest) {
        log.debug("[start] DestinatarioApplicationService - novoDestinatario");
        Destinatario destinatario = new Destinatario(novoDestinatarioRequest);
        destinatarioRepository.salvaDestinatario(destinatario);
        log.debug("[finish] DestinatarioApplicationService - novoDestinatario");
        return new NovoDestinatarioResponse(destinatario);
    }

    @Override
    public DestinatarioResponse buscaDestinatarioPorId(UUID idDestinatario) {
        log.debug("[start] DestinatarioApplicationService - buscaDestinatarioPorId");
        Destinatario destinatario = destinatarioRepository.buscaDestinatarioPorId(idDestinatario);
        log.debug("[finish] DestinatarioApplicationService - buscaDestinatarioPorId");
        return new DestinatarioResponse(destinatario);
    }

    @Override
    public void alteraDestinatario(DestinatarioRequest editaDestinatarioRequest, UUID idDestinatario) {
        log.debug("[start] DestinatarioApplicationService - alteraDestinatario");
        Destinatario destinatario = destinatarioRepository.buscaDestinatarioPorId(idDestinatario);
        destinatario.alteraDestinatario(editaDestinatarioRequest);
        destinatarioRepository.salvaDestinatario(destinatario);
        log.debug("[finish] DestinatarioApplicationService - alteraDestinatario");
    }
}
