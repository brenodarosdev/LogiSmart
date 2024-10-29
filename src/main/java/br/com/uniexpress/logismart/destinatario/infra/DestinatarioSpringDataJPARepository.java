package br.com.uniexpress.logismart.destinatario.infra;

import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DestinatarioSpringDataJPARepository extends JpaRepository<Destinatario, UUID> {
}
