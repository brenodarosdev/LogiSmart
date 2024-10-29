package br.com.uniexpress.logismart.remetente.infra;

import br.com.uniexpress.logismart.remetente.domain.Remetente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RemetenteSpringDataJPARepository extends JpaRepository<Remetente, UUID> {
}
