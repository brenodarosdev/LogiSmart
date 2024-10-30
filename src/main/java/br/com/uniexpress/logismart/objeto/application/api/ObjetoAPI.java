package br.com.uniexpress.logismart.objeto.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Objeto")
@RequestMapping("/public/v1/objeto")
public interface ObjetoAPI {
    @PostMapping("/novo-objeto")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria novo objeto")
    NovoObjetoResponse postNovoObjeto(@RequestBody @Valid ObjetoRequest novoObjetoRequest);

    @GetMapping("/busca-objeto/{idObjeto}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca objeto por ID")
    ObjetoResponse getBuscaObjetoPorId(@PathVariable UUID idObjeto);

    @PatchMapping("/altera-objeto/{idObjeto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Edita campos do objeto")
    void patchAlteraObjeto(@RequestBody @Valid ObjetoRequest alteraObjetoRequest, @PathVariable UUID idObjeto);

    @DeleteMapping("/deleta-objeto/{idObjeto}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta objeto")
    void deleteDeletaObjeto(@PathVariable UUID idObjeto);

    @PatchMapping("/a-caminho/{idObjeto}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(summary = "Muda status para A_CAMINHO")
    void patchAlteraStatusParaACaminho(@PathVariable UUID idObjeto);
}
