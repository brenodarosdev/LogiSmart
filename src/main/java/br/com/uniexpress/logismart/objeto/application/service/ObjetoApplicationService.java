package br.com.uniexpress.logismart.objeto.application.service;

import br.com.uniexpress.logismart.objeto.application.api.NovoObjetoResponse;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ObjetoApplicationService implements ObjetoService {
    @Override
    public NovoObjetoResponse novoObjeto(ObjetoRequest novoObjetoRequest) {
        log.debug("[start] ObjetoApplicationService - novoObjeto");
        log.debug("[finish] ObjetoApplicationService - novoObjeto");
        return null;
    }
}
