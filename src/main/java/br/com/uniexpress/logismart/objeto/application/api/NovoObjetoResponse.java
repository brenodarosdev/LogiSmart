package br.com.uniexpress.logismart.objeto.application.api;

import br.com.uniexpress.logismart.objeto.domain.Objeto;
import br.com.uniexpress.logismart.objeto.domain.StausEnvio;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class NovoObjetoResponse {
    private UUID idObjeto;
    private BigDecimal valorFrete;
    private StausEnvio status;
    private String cepDeDestino;

    public NovoObjetoResponse(Objeto objeto) {
        this.idObjeto = objeto.getId();
        this.valorFrete = objeto.getValorFrete();
        this.status = objeto.getStatus();
        this.cepDeDestino = objeto.getCepDeDestino();
    }
}
