package br.com.uniexpress.logismart.viacep.infra.client;

import br.com.uniexpress.logismart.viacep.application.service.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepClientFeign", url = "${viacep.url}")
public interface ViaCepClientFeign {
    @GetMapping("/{cep}/json")
    ViaCepResponse consultaCep(@PathVariable String cep);
}
