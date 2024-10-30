package br.com.uniexpress.logismart.apiLog.application.service;

import br.com.uniexpress.logismart.apiLog.domain.ApiLog;
import br.com.uniexpress.logismart.apiLog.infra.ApiLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ApiLogApplicationService implements ApiLogService {
    private final ApiLogRepository apiLogRepository;

    @Override
    public void salvaLog(String response) {
        log.debug("[start] ApiLogApplicationService - salvaLog");
        apiLogRepository.salvaLog(new ApiLog(response));
        log.debug("[finish] ApiLogApplicationService - salvaLog");
    }
}
