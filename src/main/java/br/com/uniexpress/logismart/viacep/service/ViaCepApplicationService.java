package br.com.uniexpress.logismart.viacep.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ViaCepApplicationService implements ViaCepService {
    @Override
    public ViaCepResponse ConsultaCep(String cep) {
        log.debug("[start] ViaCepApplicationService - ConsultaCep");
        log.debug("[finish] ViaCepApplicationService - ConsultaCep");
        return null;
    }
}
