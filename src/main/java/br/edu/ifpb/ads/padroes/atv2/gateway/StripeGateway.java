package br.edu.ifpb.ads.padroes.atv2.gateway;

import br.edu.ifpb.ads.padroes.atv2.core.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.core.ResultadoPagamento;

/**
 * Implementação de PagamentoGateway para Stripe
 */
public class StripeGateway implements PagamentoGateway {

    private final StripeSDK sdk;

    public StripeGateway() {
        this.sdk = new StripeSDK();
    }

    @Override
    public ResultadoPagamento processar(double valor) {
        StripeSDK.StripeTransacao transacao = sdk.processarPagamento(
            "sk_live_123456",
            "tok_visa_1234",
            valor
        );

        return new ResultadoPagamento(
            transacao.getChargeId(),
            transacao.getStatus(),
            transacao.getAmount(),
            getNome()
        );
    }

    @Override
    public String getNome() {
        return "Stripe";
    }
}
