package br.edu.ifpb.ads.padroes.atv2.gateway;

import br.edu.ifpb.ads.padroes.atv2.core.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.core.ResultadoPagamento;

/**
 * Implementação de PagamentoGateway para PagSeguro
 */
public class PagSeguroGateway implements PagamentoGateway {

    private final PagSeguroSDK sdk;

    public PagSeguroGateway() {
        this.sdk = new PagSeguroSDK();
    }

    @Override
    public ResultadoPagamento processar(double valor) {
        PagSeguroSDK.PagSeguroTransacao transacao = sdk.processarPagamento(
            "vendedor@email.com",
            "token_transacao_789",
            valor
        );

        return new ResultadoPagamento(
            transacao.getCodigoTransacao(),
            transacao.getStatus(),
            transacao.getValor(),
            getNome()
        );
    }

    @Override
    public String getNome() {
        return "PagSeguro";
    }
}
