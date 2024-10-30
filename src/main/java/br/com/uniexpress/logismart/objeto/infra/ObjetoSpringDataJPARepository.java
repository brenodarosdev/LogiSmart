package br.com.uniexpress.logismart.objeto.infra;

import br.com.uniexpress.logismart.objeto.domain.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ObjetoSpringDataJPARepository extends JpaRepository<Objeto, UUID> {
}
