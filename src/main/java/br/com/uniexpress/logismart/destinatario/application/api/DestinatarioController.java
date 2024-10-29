package br.com.uniexpress.logismart.destinatario.application.api;

import br.com.uniexpress.logismart.destinatario.application.service.DestinatarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class DestinatarioController implements DestinatarioAPI {
    private final DestinatarioService destinatarioService;

    @Override
    public NovoDestinatarioResponse postNovoDestinatario(DestinatarioRequest novoDestinatarioRequest) {
        log.debug("[start] DestinatarioController - postNovoDestinatario");
        NovoDestinatarioResponse response = destinatarioService.novoDestinatario(novoDestinatarioRequest);
        log.debug("[finish] DestinatarioController - postNovoDestinatario");
        return response;
    }

    @Override
    public DestinatarioResponse getBuscaDestinatarioPorId(UUID idDestinatario) {
        log.debug("[start] DestinatarioController - getBuscaDestinatarioPorId");
        DestinatarioResponse response = destinatarioService.buscaDestinatarioPorId(idDestinatario);
        log.debug("[finish] DestinatarioController - getBuscaDestinatarioPorId");
        return response;
    }

    @Override
    public void patchAlteraDestinatario(DestinatarioRequest alteraDestinatarioRequest, UUID idDestinatario) {
        log.debug("[start] DestinatarioController - patchAlteraDestinatario");
        destinatarioService.alteraDestinatario(alteraDestinatarioRequest, idDestinatario);
        log.debug("[finish] DestinatarioController - patchAlteraDestinatario");
    }

    @Override
    public void deleteDeletaDestinatario(UUID idDestinatario) {
        log.debug("[start] DestinatarioController - deleteDeletaDestinatario");
        log.debug("[finish] DestinatarioController - deleteDeletaDestinatario");
    }
}
