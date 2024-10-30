package br.com.uniexpress.logismart.remetente.application.api;

import br.com.uniexpress.logismart.remetente.domain.Remetente;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class RemetenteResponse {
    private UUID id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String cep;

    public RemetenteResponse(Remetente remetente) {
        this.id = remetente.getId();
        this.nome = remetente.getNome();
        this.cnpj = remetente.getCnpj();
        this.telefone = remetente.getTelefone();
        this.email = remetente.getEmail();
        this.cep = remetente.getCep();
    }
}
