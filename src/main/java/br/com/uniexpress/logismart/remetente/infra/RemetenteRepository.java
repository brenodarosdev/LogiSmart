package br.com.uniexpress.logismart.remetente.infra;

import br.com.uniexpress.logismart.remetente.domain.Remetente;

import java.util.UUID;

public interface RemetenteRepository {
    void salvaRemetente(Remetente remetente);
    Remetente buscaRemetentePorId(UUID idRemetente);
}
