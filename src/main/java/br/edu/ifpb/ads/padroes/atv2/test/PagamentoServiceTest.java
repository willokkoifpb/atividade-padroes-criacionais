package br.edu.ifpb.ads.padroes.atv2.test;

import br.edu.ifpb.ads.padroes.atv2.config.PagamentoConfig;
import br.edu.ifpb.ads.padroes.atv2.core.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.core.PagamentoService;
import br.edu.ifpb.ads.padroes.atv2.core.ResultadoPagamento;
import br.edu.ifpb.ads.padroes.atv2.gateway.PayPalGateway;
import br.edu.ifpb.ads.padroes.atv2.gateway.StripeGateway;
import br.edu.ifpb.ads.padroes.atv2.gateway.PagSeguroGateway;
import br.edu.ifpb.ads.padroes.atv2.gateway.PixGateway;

/**
 * Classe de teste (simulado) que demonstra a testabilidade do sistema
 * com injeção de dependência
 */
public class PagamentoServiceTest {

    public static void main(String[] args) {
        System.out.println("=== Testes do Sistema de Pagamentos ===\n");

        testarPayPal();
        testarStripe();
        testarPagSeguro();
        testarPix();
        testarMockGateway();

        System.out.println("\n✓ Todos os testes passaram com sucesso!");
    }

    private static void testarPayPal() {
        System.out.println("Teste 1: PayPal");
        PagamentoConfig config = new PagamentoConfig();
        PagamentoService service = config.criarServiceComPayPal();
        
        ResultadoPagamento resultado = service.pagar(100.00);
        assert resultado.isSucesso() : "PayPal deve processar pagamento com sucesso";
        assert resultado.getValor() == 100.00 : "Valor deve ser 100.00";
        assert "PayPal".equals(resultado.getGateway()) : "Gateway deve ser PayPal";
        assert resultado.getId().startsWith("PAYPAL_") : "ID deve começar com PAYPAL_";
        
        System.out.println("  ✓ PASSOU\n");
    }

    private static void testarStripe() {
        System.out.println("Teste 2: Stripe");
        PagamentoConfig config = new PagamentoConfig();
        PagamentoService service = config.criarServiceComStripe();
        
        ResultadoPagamento resultado = service.pagar(250.50);
        assert resultado.isSucesso() : "Stripe deve processar pagamento com sucesso";
        assert resultado.getValor() == 250.50 : "Valor deve ser 250.50";
        assert "Stripe".equals(resultado.getGateway()) : "Gateway deve ser Stripe";
        assert resultado.getId().startsWith("ch_") : "ID deve começar com ch_";
        
        System.out.println("  ✓ PASSOU\n");
    }

    private static void testarPagSeguro() {
        System.out.println("Teste 3: PagSeguro");
        PagamentoConfig config = new PagamentoConfig();
        PagamentoService service = config.criarServiceComPagSeguro();
        
        ResultadoPagamento resultado = service.pagar(500.00);
        assert resultado.isSucesso() : "PagSeguro deve processar pagamento com sucesso";
        assert resultado.getValor() == 500.00 : "Valor deve ser 500.00";
        assert "PagSeguro".equals(resultado.getGateway()) : "Gateway deve ser PagSeguro";
        assert resultado.getId().startsWith("PS_") : "ID deve começar com PS_";
        
        System.out.println("  ✓ PASSOU\n");
    }

    private static void testarPix() {
        System.out.println("Teste 4: Pix (Gateway novo)");
        PagamentoConfig config = new PagamentoConfig();
        PagamentoService service = config.criarServiceComGateway(PixGateway.class);
        
        ResultadoPagamento resultado = service.pagar(150.75);
        assert resultado.isSucesso() : "Pix deve processar pagamento com sucesso";
        assert resultado.getValor() == 150.75 : "Valor deve ser 150.75";
        assert "Pix".equals(resultado.getGateway()) : "Gateway deve ser Pix";
        assert resultado.getId().startsWith("PIX_") : "ID deve começar com PIX_";
        
        System.out.println("  ✓ PASSOU\n");
    }

    private static void testarMockGateway() {
        System.out.println("Teste 5: Gateway Mock (injeção de dependência)");
        
        // Criar um gateway mock para teste
        class GatewayMock implements PagamentoGateway {
            @Override
            public ResultadoPagamento processar(double valor) {
                return new ResultadoPagamento("MOCK_123", "TESTE", valor, "Mock");
            }

            @Override
            public String getNome() {
                return "Mock";
            }
        }

        // Criar serviço com mock via injeção de dependência
        PagamentoService service = new PagamentoService(new GatewayMock());
        ResultadoPagamento resultado = service.pagar(99.99);
        
        assert resultado.isSucesso() == false : "Mock deve retornar status que não é sucesso";
        assert resultado.getId().equals("MOCK_123") : "ID deve ser MOCK_123";
        assert "Mock".equals(resultado.getGateway()) : "Gateway deve ser Mock";
        
        System.out.println("  ✓ PASSOU\n");
    }
}
