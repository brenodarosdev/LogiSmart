package br.com.uniexpress.logismart.viacep.application.service;

import br.com.uniexpress.logismart.apiLog.application.service.ApiLogService;
import br.com.uniexpress.logismart.apiLog.domain.ApiLog;
import br.com.uniexpress.logismart.viacep.infra.client.ViaCepClientFeign;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class ViaCepApplicationService implements ViaCepService {
    private final ViaCepClientFeign viaCepClientFeign;
    private final ApiLogService apiLogService;

    @Override
    public ViaCepResponse consultaCep(String cep) {
        log.debug("[start] ViaCepApplicationService - ConsultaCep");
        ViaCepResponse response = viaCepClientFeign.consultaCep(cep);
        apiLogService.salvaLog(response.toString());
        log.debug("[finish] ViaCepApplicationService - ConsultaCep");
        return response;
    }
}
