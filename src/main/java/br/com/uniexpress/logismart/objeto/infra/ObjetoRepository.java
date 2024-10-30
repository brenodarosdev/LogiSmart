package br.com.uniexpress.logismart.objeto.infra;

import br.com.uniexpress.logismart.objeto.domain.Objeto;

public interface ObjetoRepository {
    void salvaObjeto(Objeto objeto);
}
