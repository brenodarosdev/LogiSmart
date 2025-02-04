package br.com.uniexpress.logismart.objeto.application.api;

import br.com.uniexpress.logismart.objeto.application.service.ObjetoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ObjetoController implements ObjetoAPI {
    private final ObjetoService objetoService;

    @Override
    public NovoObjetoResponse postNovoObjeto(ObjetoRequest novoObjetoRequest) {
        log.debug("[start] ObjetoController - postNovoObjeto");
        NovoObjetoResponse response = objetoService.novoObjeto(novoObjetoRequest);
        log.debug("[finish] ObjetoController - postNovoObjeto");
        return response;
    }

    @Override
    public ObjetoResponse getBuscaObjetoPorId(UUID idObjeto) {
        log.debug("[start] ObjetoController - getBuscaObjetoPorId");
        ObjetoResponse response = objetoService.buscaObjetoPorId(idObjeto);
        log.debug("[finish] ObjetoController - getBuscaObjetoPorId");
        return response;
    }

    @Override
    public void patchAlteraObjeto(ObjetoRequest alteraObjetoRequest, UUID idObjeto) {
        log.debug("[start] ObjetoController - patchAlteraObjeto");
        objetoService.alteraObjeto(alteraObjetoRequest, idObjeto);
        log.debug("[finish] ObjetoController - patchAlteraObjeto");
    }

    @Override
    public void deleteDeletaObjeto(UUID idObjeto) {
        log.debug("[start] ObjetoController - deleteDeletaObjeto");
        objetoService.deletaObjeto(idObjeto);
        log.debug("[finish] ObjetoController - deleteDeletaObjeto");
    }

    @Override
    public void patchAlteraStatusParaACaminho(UUID idObjeto) {
        log.debug("[start] ObjetoController - patchAlteraStatusParaACaminho");
        objetoService.alteraStatusParaACaminho(idObjeto);
        log.debug("[finish] ObjetoController - patchAlteraStatusParaACaminho");
    }

    @Override
    public void patchAlteraStatusParaEntregue(UUID idObjeto) {
        log.debug("[start] ObjetoController - patchAlteraStatusParaEntregue");
        objetoService.alteraStatusParaEntregue(idObjeto);
        log.debug("[finish] ObjetoController - patchAlteraStatusParaEntregue");
    }
}
