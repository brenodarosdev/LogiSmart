package br.com.uniexpress.logismart.destinatario.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Destinatário")
@RequestMapping("/public/v1/destinatario")
public interface DestinatarioAPI {
    @PostMapping("/novo-destinatario")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria novo destinatario")
    NovoDestinatarioResponse postNovoDestinatario(@RequestBody @Valid DestinatarioRequest novoDestinatarioRequest);

    @GetMapping("/busca-destinatario/{idDestinatario}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca destinatario por ID")
    DestinatarioResponse getBuscaDestinatarioPorId(@PathVariable UUID idDestinatario);

    @PatchMapping("/edita-destinatario/{idDestinatario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Edita campos do destinatario")
    void patchAlteraDestinatario(@RequestBody @Valid DestinatarioRequest editaDestinatarioRequest,
                                 @PathVariable UUID idDestinatario);
}
