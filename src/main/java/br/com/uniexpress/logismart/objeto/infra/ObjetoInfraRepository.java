package br.com.uniexpress.logismart.objeto.infra;

import br.com.uniexpress.logismart.objeto.domain.Objeto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ObjetoInfraRepository implements ObjetoRepository {
    @Override
    public void salvaObjeto(Objeto objeto) {
        log.debug("[start] ObjetoInfraRepository - salvaObjeto");
        log.debug("[finish] ObjetoInfraRepository - salvaObjeto");
    }
}
