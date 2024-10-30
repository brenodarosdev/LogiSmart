package br.com.uniexpress.logismart.objeto.infra;

import br.com.uniexpress.logismart.objeto.domain.Objeto;

import java.util.UUID;

public interface ObjetoRepository {
    void salvaObjeto(Objeto objeto);
    Objeto buscaObjetoPorId(UUID idObjeto);
    void deletaObjetoPorId(UUID idObjeto);
}
