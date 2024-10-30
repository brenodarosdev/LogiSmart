package br.com.uniexpress.logismart.objeto.domain;

import br.com.uniexpress.logismart.handler.APIException;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoRequest;
import br.com.uniexpress.logismart.viacep.application.service.ViaCepResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Objeto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @NotNull
    private UUID idRemetente;
    @NotNull
    private UUID idDestinatario;
    @NotNull
    private StausEnvio status;
    @NotBlank
    private String descricao;
    @NotNull
    private Double quilos;
    @NotNull
    private BigDecimal valorFrete;
    @NotBlank
    private String cepDeDestino;

    public Objeto(ObjetoRequest novoObjetoRequest, ViaCepResponse enderecoRemetente, ViaCepResponse enderecoDestinatario) {
        this.idRemetente = novoObjetoRequest.getIdRemetente();
        this.idDestinatario = novoObjetoRequest.getIdDestinatario();
        this.status = StausEnvio.PREPARANDO_ENVIO;
        this.descricao = novoObjetoRequest.getDescricao();
        this.quilos = novoObjetoRequest.getQuilos();
        this.valorFrete = calculaFrete(enderecoRemetente, enderecoDestinatario);
        this.cepDeDestino = enderecoDestinatario.getCep();
    }

    public BigDecimal calculaFrete(ViaCepResponse enderecoRemetente, ViaCepResponse enderecoDestinatario) {
        if (!enderecoRemetente.getUf().equals(enderecoDestinatario.getUf())) {
            return BigDecimal.valueOf(19);
        }
        return BigDecimal.ZERO;
    }

    public void alteraObjeto(ObjetoRequest alteraObjetoRequest, ViaCepResponse enderecoRemetente, ViaCepResponse enderecoDestinatario) {
        this.idRemetente = alteraObjetoRequest.getIdRemetente();
        this.idDestinatario = alteraObjetoRequest.getIdDestinatario();
        this.descricao = alteraObjetoRequest.getDescricao();
        this.quilos = alteraObjetoRequest.getQuilos();
        this.valorFrete = calculaFrete(enderecoRemetente, enderecoDestinatario);
        this.cepDeDestino = enderecoDestinatario.getCep();
    }

    public void alteraStatusParaACaminho() {
        if (!this.status.equals(StausEnvio.A_CAMINHO)) {
            this.status = StausEnvio.A_CAMINHO;
        } else {
            throw APIException.build(HttpStatus.CONFLICT, "O status já está definido para a caminho");
        }
    }

    public void alteraStatusParaEntregue() {
        if (!this.status.equals(StausEnvio.ENTREGUE)) {
            this.status = StausEnvio.ENTREGUE;
        } else {
            throw APIException.build(HttpStatus.CONFLICT, "O status já está definido para entregue");
        }
    }
}
