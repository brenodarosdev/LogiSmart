package br.com.uniexpress.logismart.destinatario.infra;

import br.com.uniexpress.logismart.destinatario.domain.Destinatario;

import java.util.UUID;

public interface DestinatarioRepository {
    void salvaDestinatario(Destinatario destinatario);
    Destinatario buscaDestinatarioPorId(UUID idDestinatario);
}
