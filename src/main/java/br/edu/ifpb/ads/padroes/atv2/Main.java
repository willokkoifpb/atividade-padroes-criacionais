package br.edu.ifpb.ads.padroes.atv2;

import br.edu.ifpb.ads.padroes.atv2.config.PagamentoConfig;
import br.edu.ifpb.ads.padroes.atv2.core.PagamentoService;
import br.edu.ifpb.ads.padroes.atv2.core.ResultadoPagamento;

/**
 * Classe principal que demonstra o uso do sistema de processamento de pagamentos
 * com injeção de dependência via Pico Container.
 * 
 * Demonstra como:
 * 1. Obter um PagamentoService com um gateway específico
 * 2. Processar um pagamento
 * 3. Trocar o gateway sem modificar PagamentoService
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Processamento de Pagamentos ===\n");

        PagamentoConfig config = new PagamentoConfig();

        // Passo 1: Criar PagamentoService com PayPal
        System.out.println("--- Teste 1: PayPal ---");
        PagamentoService servicoPayPal = config.criarServiceComPayPal();
        ResultadoPagamento resultadoPayPal = servicoPayPal.pagar(150.00);
        verificarResultado(resultadoPayPal);

        // Passo 2: Criar PagamentoService com Stripe (gateway diferente)
        System.out.println("\n--- Teste 2: Stripe ---");
        PagamentoService servicoStripe = config.criarServiceComStripe();
        ResultadoPagamento resultadoStripe = servicoStripe.pagar(250.00);
        verificarResultado(resultadoStripe);

        // Passo 3: Criar PagamentoService com PagSeguro (outro gateway diferente)
        System.out.println("\n--- Teste 3: PagSeguro ---");
        PagamentoService servicoPagSeguro = config.criarServiceComPagSeguro();
        ResultadoPagamento resultadoPagSeguro = servicoPagSeguro.pagar(350.00);
        verificarResultado(resultadoPagSeguro);

        // Demonstração: a classe PagamentoService não foi modificada
        // para suportar diferentes gateways - é totalmente extensível
        System.out.println("\n=== Conclusão ===");
        System.out.println("A classe PagamentoService é extensível e não precisa ser");
        System.out.println("modificada para suportar novos gateways.");
        System.out.println("Novos gateways podem ser adicionados implementando PagamentoGateway.");
    }

    private static void verificarResultado(ResultadoPagamento resultado) {
        System.out.println("\nResultado final:");
        System.out.println("  ID: " + resultado.getId());
        System.out.println("  Status: " + resultado.getStatus());
        System.out.println("  Valor: R$ " + resultado.getValor());
        System.out.println("  Gateway: " + resultado.getGateway());
        System.out.println("  Sucesso: " + (resultado.isSucesso() ? "SIM" : "NÃO"));
    }
}
