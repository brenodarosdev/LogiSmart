package br.com.uniexpress.logismart.objeto.application.service;

import br.com.uniexpress.logismart.objeto.application.api.NovoObjetoResponse;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoRequest;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoResponse;

import java.util.UUID;

public interface ObjetoService {
    NovoObjetoResponse novoObjeto(ObjetoRequest novoObjetoRequest);
    ObjetoResponse buscaObjetoPorId(UUID idObjeto);
    void alteraObjeto(ObjetoRequest alteraObjetoRequest, UUID idObjeto);
}
