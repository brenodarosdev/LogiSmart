package br.com.uniexpress.logismart.apiLog.application.service;

import br.com.uniexpress.logismart.apiLog.domain.ApiLog;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ApiLogApplicationService implements ApiLogService {
    @Override
    public ApiLog salvaLog(String response) {
        log.debug("[start] ApiLogApplicationService - salvaLog");

        log.debug("[finish] ApiLogApplicationService - salvaLog");
        return null;
    }
}
