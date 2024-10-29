package br.com.uniexpress.logismart.remetente.infra;

import br.com.uniexpress.logismart.remetente.domain.Remetente;

public interface RemetenteRepository {
    void salvaRemetente(Remetente remetente);
}
