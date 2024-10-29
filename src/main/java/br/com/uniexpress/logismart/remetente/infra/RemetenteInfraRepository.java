package br.com.uniexpress.logismart.remetente.infra;

import br.com.uniexpress.logismart.remetente.domain.Remetente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class RemetenteInfraRepository implements RemetenteRepository {
    @Override
    public void salvaRemetente(Remetente remetente) {
        log.debug("[start] RemetenteInfraRepository - salvaRemetente");
        log.debug("[finish] RemetenteInfraRepository - salvaRemetente");
    }
}
