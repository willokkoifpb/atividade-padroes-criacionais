package br.edu.ifpb.ads.padroes.atv2;

import br.edu.ifpb.ads.padroes.atv2.config.PagamentoConfig;
import br.edu.ifpb.ads.padroes.atv2.core.PagamentoService;
import br.edu.ifpb.ads.padroes.atv2.core.ResultadoPagamento;
import br.edu.ifpb.ads.padroes.atv2.gateway.PixGateway;

/**
 * Classe estendida que demonstra a extensibilidade do sistema.
 * Mostra como adicionar Pix sem modificar PagamentoService.
 */
public class MainComExtensao {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Processamento de Pagamentos (Com Extensão) ===\n");

        PagamentoConfig config = new PagamentoConfig();

        // Passo 1: PayPal
        System.out.println("--- Teste 1: PayPal ---");
        PagamentoService servicoPayPal = config.criarServiceComPayPal();
        ResultadoPagamento resultadoPayPal = servicoPayPal.pagar(100.00);
        verificarResultado(resultadoPayPal);

        // Passo 2: Stripe
        System.out.println("\n--- Teste 2: Stripe ---");
        PagamentoService servicoStripe = config.criarServiceComStripe();
        ResultadoPagamento resultadoStripe = servicoStripe.pagar(200.00);
        verificarResultado(resultadoStripe);

        // Passo 3: PagSeguro
        System.out.println("\n--- Teste 3: PagSeguro ---");
        PagamentoService servicoPagSeguro = config.criarServiceComPagSeguro();
        ResultadoPagamento resultadoPagSeguro = servicoPagSeguro.pagar(300.00);
        verificarResultado(resultadoPagSeguro);

        // Passo 4: Pix (novo gateway - SEM modificar PagamentoService!)
        System.out.println("\n--- Teste 4: Pix (Novo Gateway) ---");
        System.out.println("[INFO] Adicionando novo gateway Pix sem modificar código existente!");
        PagamentoService servicoPix = config.criarServiceComGateway(PixGateway.class);
        ResultadoPagamento resultadoPix = servicoPix.pagar(150.00);
        verificarResultado(resultadoPix);

        // Conclusão
        System.out.println("\n=== Conclusão ===");
        System.out.println("✓ Sistema suporta 4 gateways diferentes");
        System.out.println("✓ PagamentoService não foi modificada");
        System.out.println("✓ Sistema é aberto para extensão, fechado para modificação");
        System.out.println("✓ Novos gateways podem ser adicionados sem quebrar código existente");
    }

    private static void verificarResultado(ResultadoPagamento resultado) {
        System.out.println("\nResultado:");
        System.out.println("  ✓ ID: " + resultado.getId());
        System.out.println("  ✓ Status: " + resultado.getStatus());
        System.out.println("  ✓ Valor: R$ " + String.format("%.2f", resultado.getValor()));
        System.out.println("  ✓ Gateway: " + resultado.getGateway());
        System.out.println("  ✓ Sucesso: " + (resultado.isSucesso() ? "✓ SIM" : "✗ NÃO"));
    }
}
