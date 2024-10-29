package br.com.uniexpress.logismart.destinatario.infra;

import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class DestinatarioInfraRepository implements DestinatarioRepository {
    @Override
    public void salvaDestinatario(Destinatario destinatario) {
        log.debug("[start] DestinatarioInfraRepository - salvaDestinatario");
        log.debug("[finish] DestinatarioInfraRepository - salvaDestinatario");
    }
}
