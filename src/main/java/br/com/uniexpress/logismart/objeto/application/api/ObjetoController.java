package br.com.uniexpress.logismart.objeto.application.api;

import br.com.uniexpress.logismart.objeto.application.service.ObjetoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
