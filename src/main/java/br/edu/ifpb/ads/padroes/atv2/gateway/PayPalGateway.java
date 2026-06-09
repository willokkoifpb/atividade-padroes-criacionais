package br.edu.ifpb.ads.padroes.atv2.gateway;

import br.edu.ifpb.ads.padroes.atv2.core.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.core.ResultadoPagamento;

/**
 * Implementação de PagamentoGateway para PayPal
 */
public class PayPalGateway implements PagamentoGateway {

    private final PayPalSDK sdk;

    public PayPalGateway() {
        this.sdk = new PayPalSDK();
    }

    @Override
    public ResultadoPagamento processar(double valor) {
        PayPalSDK.PayPalTransacao transacao = sdk.processarPagamento(
            "client_id_123",
            "client_secret_456",
            valor
        );

        return new ResultadoPagamento(
            transacao.getTransactionId(),
            transacao.getStatus(),
            transacao.getAmount(),
            getNome()
        );
    }

    @Override
    public String getNome() {
        return "PayPal";
    }
}
