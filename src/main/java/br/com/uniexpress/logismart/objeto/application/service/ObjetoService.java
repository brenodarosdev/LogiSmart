package br.com.uniexpress.logismart.objeto.application.service;

import br.com.uniexpress.logismart.objeto.application.api.NovoObjetoResponse;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoRequest;

public interface ObjetoService {
    NovoObjetoResponse novoObjeto(ObjetoRequest novoObjetoRequest);
}
