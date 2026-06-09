package br.edu.ifpb.ads.padroes.atv2.gateway;

import br.edu.ifpb.ads.padroes.atv2.core.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.core.ResultadoPagamento;

/**
 * Implementação de PagamentoGateway para Pix
 * Exemplo de como o sistema é extensível - nenhuma modificação foi necessária em PagamentoService
 */
public class PixGateway implements PagamentoGateway {

    private final PixSDK sdk;

    public PixGateway() {
        this.sdk = new PixSDK();
    }

    @Override
    public ResultadoPagamento processar(double valor) {
        PixSDK.PixTransacao transacao = sdk.processarPagamento(
            "chave_pix@banco.com",
            "uuid_idempotencia",
            valor
        );

        return new ResultadoPagamento(
            transacao.getE2eId(),
            transacao.getStatus(),
            transacao.getValor(),
            getNome()
        );
    }

    @Override
    public String getNome() {
        return "Pix";
    }
}
