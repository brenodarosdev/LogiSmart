package br.com.uniexpress.logismart.objeto.application.service;

import br.com.uniexpress.logismart.destinatario.application.service.DestinatarioApplicationService;
import br.com.uniexpress.logismart.destinatario.application.service.DestinatarioService;
import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import br.com.uniexpress.logismart.destinatario.infra.DestinatarioRepository;
import br.com.uniexpress.logismart.objeto.application.api.NovoObjetoResponse;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoRequest;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoResponse;
import br.com.uniexpress.logismart.objeto.domain.Objeto;
import br.com.uniexpress.logismart.objeto.infra.ObjetoRepository;
import br.com.uniexpress.logismart.remetente.domain.Remetente;
import br.com.uniexpress.logismart.remetente.infra.RemetenteInfraRepository;
import br.com.uniexpress.logismart.remetente.infra.RemetenteRepository;
import br.com.uniexpress.logismart.viacep.application.service.ViaCepResponse;
import br.com.uniexpress.logismart.viacep.application.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class ObjetoApplicationService implements ObjetoService {
    private final RemetenteRepository remetenteRepository;
    private final DestinatarioRepository destinatarioRepository;
    private final ViaCepService viaCepService;
    private final ObjetoRepository objetoRepository;

    @Override
    public NovoObjetoResponse novoObjeto(ObjetoRequest novoObjetoRequest) {
        log.debug("[start] ObjetoApplicationService - novoObjeto");
        Remetente remetente = remetenteRepository.buscaRemetentePorId(novoObjetoRequest.getIdRemetente());
        Destinatario destinatario = destinatarioRepository.buscaDestinatarioPorId(novoObjetoRequest.getIdDestinatario());
        ViaCepResponse enderecoRemetente = viaCepService.consultaCep(remetente.getCep());
        ViaCepResponse enderecoDestinatario = viaCepService.consultaCep(destinatario.getCep());
        Objeto objeto = new Objeto(novoObjetoRequest, enderecoRemetente, enderecoDestinatario);
        objetoRepository.salvaObjeto(objeto);
        log.debug("[finish] ObjetoApplicationService - novoObjeto");
        return new NovoObjetoResponse(objeto);
    }

    @Override
    public ObjetoResponse buscaObjetoPorId(UUID idObjeto) {
        log.debug("[start] ObjetoApplicationService - buscaObjetoPorId");
        Objeto objeto = objetoRepository.buscaObjetoPorId(idObjeto);
        log.debug("[finish] ObjetoApplicationService - buscaObjetoPorId");
        return new ObjetoResponse(objeto);
    }

    @Override
    public void alteraObjeto(ObjetoRequest alteraObjetoRequest, UUID idObjeto) {
        log.debug("[start] ObjetoApplicationService - alteraObjeto");
        Objeto objeto = objetoRepository.buscaObjetoPorId(idObjeto);
        Remetente remetente = remetenteRepository.buscaRemetentePorId(alteraObjetoRequest.getIdRemetente());
        Destinatario destinatario = destinatarioRepository.buscaDestinatarioPorId(alteraObjetoRequest.getIdDestinatario());
        ViaCepResponse enderecoRemetente = viaCepService.consultaCep(remetente.getCep());
        ViaCepResponse enderecoDestinatario = viaCepService.consultaCep(destinatario.getCep());
        objeto.alteraObjeto(alteraObjetoRequest, enderecoRemetente, enderecoDestinatario);
        objetoRepository.salvaObjeto(objeto);
        log.debug("[finish] ObjetoApplicationService - alteraObjeto");
    }
}
