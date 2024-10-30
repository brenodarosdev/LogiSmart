package br.com.uniexpress.logismart.objeto.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class ObjetoController implements ObjetoAPI {
    @Override
    public NovoObjetoResponse postNovoObjeto(ObjetoRequest novoObjetoRequest) {
        log.debug("[start] ObjetoController - postNovoObjeto");
        log.debug("[finish] ObjetoController - postNovoObjeto");
        return null;
    }
}
