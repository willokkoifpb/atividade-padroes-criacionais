package br.edu.ifpb.ads.padroes.atv2.core;

/**
 * Abstração que define o contrato para qualquer gateway de pagamento.
 * Permite que novos gateways sejam adicionados sem modificar PagamentoService.
 */
public interface PagamentoGateway {

    /**
     * Processa um pagamento com o valor especificado
     * @param valor Valor a ser pago
     * @return Resultado do pagamento
     */
    ResultadoPagamento processar(double valor);

    /**
     * Retorna o nome do gateway
     */
    String getNome();
}
