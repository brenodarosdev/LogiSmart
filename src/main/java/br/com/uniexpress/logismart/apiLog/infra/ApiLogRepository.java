package br.com.uniexpress.logismart.apiLog.infra;

import br.com.uniexpress.logismart.apiLog.domain.ApiLog;

public interface ApiLogRepository {
    void salvaLog(ApiLog apiLog);
}
