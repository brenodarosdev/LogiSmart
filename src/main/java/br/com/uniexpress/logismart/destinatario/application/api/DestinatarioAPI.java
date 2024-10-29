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
    @Operation(summary = "Cria novo destinatário")
    NovoDestinatarioResponse postNovoDestinatario(@RequestBody @Valid DestinatarioRequest novoDestinatarioRequest);

    @GetMapping("/busca-destinatario/{idDestinatario}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca destinatário por ID")
    DestinatarioResponse getBuscaDestinatarioPorId(@PathVariable UUID idDestinatario);

    @PatchMapping("/altera-destinatario/{idDestinatario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Edita campos do destinatário")
    void patchAlteraDestinatario(@RequestBody @Valid DestinatarioRequest alteraDestinatarioRequest,
                                 @PathVariable UUID idDestinatario);

    @DeleteMapping("/deleta-destinatario/{idDestinatario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta destinatário")
    void deleteDeletaDestinatario(@PathVariable UUID idDestinatario);
}
