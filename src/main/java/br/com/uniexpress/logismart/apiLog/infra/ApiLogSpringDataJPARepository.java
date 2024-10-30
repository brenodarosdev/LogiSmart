package br.com.uniexpress.logismart.apiLog.infra;

import br.com.uniexpress.logismart.apiLog.domain.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApiLogSpringDataJPARepository extends JpaRepository<ApiLog, UUID> {
}
