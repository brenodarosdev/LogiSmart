package br.com.uniexpress.logismart.objeto.infra;

import br.com.uniexpress.logismart.handler.APIException;
import br.com.uniexpress.logismart.objeto.domain.Objeto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ObjetoInfraRepository implements ObjetoRepository {
    private final ObjetoSpringDataJPARepository objetoSpringDataJPARepository;

    @Override
    public void salvaObjeto(Objeto objeto) {
        log.debug("[start] ObjetoInfraRepository - salvaObjeto");
        objetoSpringDataJPARepository.save(objeto);
        log.debug("[finish] ObjetoInfraRepository - salvaObjeto");
    }

    @Override
    public Objeto buscaObjetoPorId(UUID idObjeto) {
        log.debug("[start] ObjetoInfraRepository - buscaObjetoPorId");
        Objeto objeto = objetoSpringDataJPARepository.findObjetoById(idObjeto)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Objeto não encontrado!"));
        log.debug("[finish] ObjetoInfraRepository - buscaObjetoPorId");
        return objeto;
    }

    @Override
    public void deletaObjetoPorId(UUID idObjeto) {
        log.debug("[start] ObjetoInfraRepository - deletaObjetoPorId");
        objetoSpringDataJPARepository.deleteById(idObjeto);
        log.debug("[finish] ObjetoInfraRepository - deletaObjetoPorId");
    }
}
