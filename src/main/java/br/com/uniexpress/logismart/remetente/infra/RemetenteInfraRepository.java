package br.com.uniexpress.logismart.remetente.infra;

import br.com.uniexpress.logismart.handler.APIException;
import br.com.uniexpress.logismart.remetente.domain.Remetente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class RemetenteInfraRepository implements RemetenteRepository {
    private final RemetenteSpringDataJPARepository remetenteSpringDataJPARepository;

    @Override
    public void salvaRemetente(Remetente remetente) {
        log.debug("[start] RemetenteInfraRepository - salvaRemetente");
        try {
            remetenteSpringDataJPARepository.save(remetente);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um remetente cadastrado com esse email ou telefone.");
        }
        log.debug("[finish] RemetenteInfraRepository - salvaRemetente");
    }
}
