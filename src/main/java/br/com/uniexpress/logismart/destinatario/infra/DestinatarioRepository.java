package br.com.uniexpress.logismart.destinatario.infra;

import br.com.uniexpress.logismart.destinatario.domain.Destinatario;

public interface DestinatarioRepository {
    void salvaDestinatario(Destinatario destinatario);
}
