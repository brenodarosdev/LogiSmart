package br.com.uniexpress.logismart.remetente.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Remetente")
@RequestMapping("/public/v1/remetente")
public interface RemetenteAPI {
    @PostMapping("/novo-remetente")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria novo remetente")
    NovoRemetenteResponse postNovoRemetente(RemetenteRequest novoRemetenteRequest);
}
