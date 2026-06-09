package br.edu.ifpb.ads.padroes.atv2.gateway;

/**
 * Mock SDK do Pix - simula chamadas para a API do Pix (exemplo de extensibilidade)
 * Demonstra como novos gateways podem ser adicionados sem modificar o código existente
 */
public class PixSDK {

    public PixSDK() {
        System.out.println("[Pix SDK] Inicializado");
    }

    public PixTransacao processarPagamento(String chavePixRecebedor, String idempotencyKey, double valor) {
        System.out.println("[Pix] Processando pagamento de R$ " + valor);
        System.out.println("[Pix] Chave Pix: " + chavePixRecebedor);
        
        // Simula sucesso na transação
        return new PixTransacao(
            "PIX_" + System.currentTimeMillis(),
            "CONFIRMED",
            valor
        );
    }

    public static class PixTransacao {
        private String e2eId;
        private String status;
        private double valor;

        public PixTransacao(String e2eId, String status, double valor) {
            this.e2eId = e2eId;
            this.status = status;
            this.valor = valor;
        }

        public String getE2eId() {
            return e2eId;
        }

        public String getStatus() {
            return status;
        }

        public double getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return "PixTransacao{" +
                    "e2eId='" + e2eId + '\'' +
                    ", status='" + status + '\'' +
                    ", valor=" + valor +
                    '}';
        }
    }
}
