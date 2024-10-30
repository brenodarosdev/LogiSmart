package br.com.uniexpress.logismart.objeto.application.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Objeto")
@RequestMapping("/public/v1/objeto")
public interface ObjetoAPI {
    @PostMapping("/novo-objeto")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria novo objeto")
    NovoObjetoResponse postNovoObjeto(@RequestBody @Valid ObjetoRequest novoObjetoRequest);
}
