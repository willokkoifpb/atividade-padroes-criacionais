package br.edu.ifpb.ads.padroes.atv2.gateway;

/**
 * Mock SDK do PayPal - simula chamadas para a API do PayPal
 */
public class PayPalSDK {

    public PayPalSDK() {
        System.out.println("[PayPal SDK] Inicializado");
    }

    public PayPalTransacao processarPagamento(String clientId, String clientSecret, double valor) {
        System.out.println("[PayPal] Processando pagamento de R$ " + valor);
        System.out.println("[PayPal] Client ID: " + clientId);
        
        // Simula sucesso na transação
        return new PayPalTransacao(
            "PAYPAL_" + System.currentTimeMillis(),
            "APPROVED",
            valor
        );
    }

    public static class PayPalTransacao {
        private String transactionId;
        private String status;
        private double amount;

        public PayPalTransacao(String transactionId, String status, double amount) {
            this.transactionId = transactionId;
            this.status = status;
            this.amount = amount;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public String getStatus() {
            return status;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "PayPalTransacao{" +
                    "transactionId='" + transactionId + '\'' +
                    ", status='" + status + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }
}
