package br.com.uniexpress.logismart.objeto.application.api;

import br.com.uniexpress.logismart.objeto.domain.Objeto;
import br.com.uniexpress.logismart.objeto.domain.StausEnvio;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class ObjetoResponse {
    private UUID id;
    private UUID idRemetente;
    private UUID idDestinatario;
    private StausEnvio status;
    private String descricao;
    private Double quilos;
    private BigDecimal valorFrete;
    private String cepDeDestino;

    public ObjetoResponse(Objeto objeto) {
        this.id = objeto.getId();
        this.idRemetente = objeto.getIdRemetente();
        this.idDestinatario = objeto.getIdDestinatario();
        this.status = objeto.getStatus();
        this.descricao = objeto.getDescricao();
        this.quilos = objeto.getQuilos();
        this.valorFrete = objeto.getValorFrete();
        this.cepDeDestino = objeto.getCepDeDestino();
    }
}
