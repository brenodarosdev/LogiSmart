package br.com.uniexpress.logismart.objeto.application.service;

import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import br.com.uniexpress.logismart.destinatario.infra.DestinatarioRepository;
import br.com.uniexpress.logismart.objeto.application.api.NovoObjetoResponse;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoRequest;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoResponse;
import br.com.uniexpress.logismart.objeto.domain.Objeto;
import br.com.uniexpress.logismart.objeto.infra.ObjetoRepository;
import br.com.uniexpress.logismart.remetente.domain.Remetente;
import br.com.uniexpress.logismart.remetente.infra.RemetenteRepository;
import br.com.uniexpress.logismart.util.DataHelper;
import br.com.uniexpress.logismart.viacep.application.service.ViaCepResponse;
import br.com.uniexpress.logismart.viacep.application.service.ViaCepService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObjetoApplicationServiceTest {
    @InjectMocks
    private ObjetoApplicationService objetoApplicationService;
    @Mock
    private RemetenteRepository remetenteRepository;
    @Mock
    private DestinatarioRepository destinatarioRepository;
    @Mock
    private ViaCepService viaCepService;
    @Mock
    private ObjetoRepository objetoRepository;

    @Test
    void deveSalvarNovoObjeto() {
        Remetente remetente = DataHelper.criaRemetente();
        UUID idRemetente = remetente.getId();
        Destinatario destinatario = DataHelper.criaDestinatario();
        UUID idDestinatario = destinatario.getId();
        ViaCepResponse enderecoRemetente = DataHelper.criaViaCepResponse();
        ViaCepResponse enderecoDestinatario = DataHelper.criaViaCepResponse2();
        ObjetoRequest objetoRequest = DataHelper.criaObjetoRequest();

        when(remetenteRepository.buscaRemetentePorId(idRemetente)).thenReturn(remetente);
        when(destinatarioRepository.buscaDestinatarioPorId(idDestinatario)).thenReturn(destinatario);
        when(viaCepService.consultaCep(remetente.getCep())).thenReturn(enderecoRemetente);
        when(viaCepService.consultaCep(destinatario.getCep())).thenReturn(enderecoDestinatario);
        NovoObjetoResponse novoObjetoResponse = objetoApplicationService.novoObjeto(objetoRequest);

        verify(objetoRepository).salvaObjeto(any(Objeto.class));
        assertNotNull(novoObjetoResponse);
        assertEquals(NovoObjetoResponse.class, novoObjetoResponse.getClass());
    }

    @Test
    void deveBuscarObjetoPorId() {
        Objeto objeto = DataHelper.criaObjeto();
        UUID idObjeto = objeto.getId();

        when(objetoRepository.buscaObjetoPorId(idObjeto)).thenReturn(objeto);
        ObjetoResponse objetoResponse = objetoApplicationService.buscaObjetoPorId(idObjeto);

        verify(objetoRepository).buscaObjetoPorId(idObjeto);
        assertNotNull(objetoResponse);
        assertEquals(ObjetoResponse.class, objetoResponse.getClass());
    }

    @Test
    void deveAlterarObjeto() {
        Objeto objeto = DataHelper.criaObjeto();
        UUID idObjeto = objeto.getId();
        Remetente remetente = DataHelper.criaRemetente();
        UUID idRemetente = remetente.getId();
        Destinatario destinatario = DataHelper.criaDestinatario();
        UUID idDestinatario = destinatario.getId();
        ViaCepResponse enderecoRemetente = DataHelper.criaViaCepResponse();
        ViaCepResponse enderecoDestinatario = DataHelper.criaViaCepResponse2();
        ObjetoRequest objetoRequest = DataHelper.criaObjetoRequest();

        when(objetoRepository.buscaObjetoPorId(idObjeto)).thenReturn(objeto);
        when(remetenteRepository.buscaRemetentePorId(idRemetente)).thenReturn(remetente);
        when(destinatarioRepository.buscaDestinatarioPorId(idDestinatario)).thenReturn(destinatario);
        when(viaCepService.consultaCep(remetente.getCep())).thenReturn(enderecoRemetente);
        when(viaCepService.consultaCep(destinatario.getCep())).thenReturn(enderecoDestinatario);
        objetoApplicationService.alteraObjeto(objetoRequest, idObjeto);

        verify(objetoRepository).salvaObjeto(any(Objeto.class));
    }

    @Test
    void deveAlterarStatusParaACaminho() {
        Objeto objeto = DataHelper.criaObjeto();
        UUID idObjeto = objeto.getId();

        when(objetoRepository.buscaObjetoPorId(idObjeto)).thenReturn(objeto);
        objetoApplicationService.alteraStatusParaACaminho(idObjeto);

        verify(objetoRepository).salvaObjeto(any(Objeto.class));
    }

    @Test
    void deveAlterarStatusParaEntregue() {
        Objeto objeto = DataHelper.criaObjeto();
        UUID idObjeto = objeto.getId();

        when(objetoRepository.buscaObjetoPorId(idObjeto)).thenReturn(objeto);
        objetoApplicationService.alteraStatusParaEntregue(idObjeto);

        verify(objetoRepository).salvaObjeto(any(Objeto.class));
    }
}