package br.com.uniexpress.logismart.apiLog.infra;

import br.com.uniexpress.logismart.apiLog.domain.ApiLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ApiLogInfraRepository implements ApiLogRepository {
    private final ApiLogSpringDataJPARepository apiLogSpringDataJPARepository;

    @Override
    public void salvaLog(ApiLog apiLog) {
        log.debug("[start] ApiLogInfraRepository - salvaLog");
        apiLogSpringDataJPARepository.save(apiLog);
        log.info(apiLog.toString());
        log.debug("[finish] ApiLogInfraRepository - salvaLog");
    }
}
