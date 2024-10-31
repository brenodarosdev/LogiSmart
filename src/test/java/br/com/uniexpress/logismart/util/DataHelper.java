package br.com.uniexpress.logismart.util;

import br.com.uniexpress.logismart.destinatario.application.api.DestinatarioRequest;
import br.com.uniexpress.logismart.destinatario.domain.Destinatario;
import br.com.uniexpress.logismart.objeto.application.api.ObjetoRequest;
import br.com.uniexpress.logismart.objeto.domain.Objeto;
import br.com.uniexpress.logismart.remetente.application.api.RemetenteRequest;
import br.com.uniexpress.logismart.remetente.domain.Remetente;
import br.com.uniexpress.logismart.viacep.application.service.ViaCepResponse;


public class DataHelper {
    public static RemetenteRequest criaRemetenteRequest() {
        return new RemetenteRequest("NTT DATA SP", "62.358.154/0001-07", "11 35129970",
                "nttdatasp@email.com", "04571-000");
    }

    public static Remetente criaRemetente() {
        return new Remetente(criaRemetenteRequest());
    }

    public static DestinatarioRequest criaDestinatarioRequest() {
        return new DestinatarioRequest("João da Silva", "11 35129970", "04571-000");
    }

    public static Destinatario criaDestinatario() {
        return new Destinatario(criaDestinatarioRequest());
    }

    public static ViaCepResponse criaViaCepResponse() {
        return new ViaCepResponse(
                "04571-000",
                "Avenida Engenheiro Luiz Carlos Berrini",
                "até 99998 - lado par",
                "",
                "Cidade Monções",
                "São Paulo",
                "SP",
                "São Paulo",
                "Sudeste",
                "3550308",
                "1004",
                "11",
                "7107"
        );
    }

    public static ViaCepResponse criaViaCepResponse2() {
        return new ViaCepResponse(
                "40436-550",
                "Rua Arcoverde",
                "",
                "",
                "Mangueira",
                "Salvador",
                "BA",
                "Bahia",
                "Nordeste",
                "2927408",
                "",
                "71",
                "3849"
        );
    }

    public static ObjetoRequest criaObjetoRequest() {
        return new ObjetoRequest(criaRemetente().getId(), criaDestinatario().getId(), "Objeto de teste", 10.0);
    }

    public static Objeto criaObjeto() {
        return new Objeto(criaObjetoRequest(), criaViaCepResponse(), criaViaCepResponse2());
    }
}
