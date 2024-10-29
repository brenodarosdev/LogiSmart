package br.com.uniexpress.logismart.destinatario.infra;

import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import br.com.uniexpress.logismart.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class DestinatarioInfraRepository implements DestinatarioRepository {
    private final DestinatarioSpringDataJPARepository destinatarioSpringDataJPARepository;

    @Override
    public void salvaDestinatario(Destinatario destinatario) {
        log.debug("[start] DestinatarioInfraRepository - salvaDestinatario");
        try {
            destinatarioSpringDataJPARepository.save(destinatario);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um destinatário cadastrado com esse telefone.");
        }
        log.debug("[finish] DestinatarioInfraRepository - salvaDestinatario");
    }

    @Override
    public Destinatario buscaDestinatarioPorId(UUID idDestinatario) {
        log.debug("[start] DestinatarioInfraRepository - buscaDestinatarioPorId");
        Destinatario destinatario = destinatarioSpringDataJPARepository.findDestinatarioById(idDestinatario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Destinatário não encontrado!"));
        log.debug("[finish] DestinatarioInfraRepository - buscaDestinatarioPorId");
        return destinatario;
    }
}
