package br.com.uniexpress.logismart.remetente.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Remetente")
@RequestMapping("/public/v1/remetente")
public interface RemetenteAPI {
    @PostMapping("/novo-remetente")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria novo remetente")
    NovoRemetenteResponse postNovoRemetente(@RequestBody @Valid RemetenteRequest novoRemetenteRequest);

    @GetMapping("/busca-remetente/{idRemetente}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca remetente por ID")
    RemetenteResponse getBuscaRemetentePorId(@PathVariable UUID idRemetente);

    @PatchMapping("/altera-remetente/{idRemetente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Edita campos do remetente")
    void patchAlteraRemetente(@RequestBody @Valid RemetenteRequest alteraRemetenteRequest,
                             @PathVariable UUID idRemetente);
}
