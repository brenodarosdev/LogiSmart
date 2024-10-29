package br.com.uniexpress.logismart.destinatario.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Destinatário")
@RequestMapping("/public/v1/destinatario")
public interface DestinatarioAPI {
    @PostMapping("/novo-destinatario")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria novo destinatario")
    NovoDestinatarioResponse postNovoDestinatario(@RequestBody @Valid DestinatarioRequest novoDestinatarioRequest);
}
