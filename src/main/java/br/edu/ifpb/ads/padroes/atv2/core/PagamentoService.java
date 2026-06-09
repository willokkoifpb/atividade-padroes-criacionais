package br.edu.ifpb.ads.padroes.atv2.core;

/**
 * Serviço de pagamento que depende de uma abstração PagamentoGateway.
 * Não conhece a implementação específica do gateway utilizado.
 * Segue o princípio de Injeção de Dependência.
 */
public class PagamentoService {

    private final PagamentoGateway gateway;

    /**
     * Construtor que recebe um gateway via injeção de dependência
     */
    public PagamentoService(PagamentoGateway gateway) {
        this.gateway = gateway;
        System.out.println("[PagamentoService] Inicializado com gateway: " + gateway.getNome());
    }

    /**
     * Processa um pagamento utilizando o gateway injetado
     */
    public ResultadoPagamento pagar(double valor) {
        System.out.println("\n[PagamentoService] Iniciando pagamento de R$ " + valor);
        System.out.println("[PagamentoService] Gateway: " + gateway.getNome());

        ResultadoPagamento resultado = gateway.processar(valor);

        System.out.println("[PagamentoService] Pagamento concluído!");
        System.out.println("[PagamentoService] Resultado: " + resultado);

        return resultado;
    }

    public String getGatewayAtual() {
        return gateway.getNome();
    }
}
