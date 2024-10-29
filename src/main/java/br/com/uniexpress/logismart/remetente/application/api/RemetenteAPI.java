package br.com.uniexpress.logismart.remetente.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Remetente")
@RequestMapping("/public/v1/remetente")
public interface RemetenteAPI {
    @PostMapping("/novo-remetente")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria novo remetente")
    NovoRemetenteResponse postNovoRemetente(@RequestBody @Valid RemetenteRequest novoRemetenteRequest);
}
