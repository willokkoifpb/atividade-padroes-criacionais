package br.edu.ifpb.ads.padroes.atv2.gateway;

/**
 * Mock SDK do Stripe - simula chamadas para a API do Stripe
 */
public class StripeSDK {

    public StripeSDK() {
        System.out.println("[Stripe SDK] Inicializado");
    }

    public StripeTransacao processarPagamento(String apiKey, String tokenCartao, double valor) {
        System.out.println("[Stripe] Processando pagamento de R$ " + valor);
        System.out.println("[Stripe] Token de cartão: " + tokenCartao);
        
        // Simula sucesso na transação
        return new StripeTransacao(
            "ch_" + System.currentTimeMillis(),
            "succeeded",
            valor
        );
    }

    public static class StripeTransacao {
        private String chargeId;
        private String status;
        private double amount;

        public StripeTransacao(String chargeId, String status, double amount) {
            this.chargeId = chargeId;
            this.status = status;
            this.amount = amount;
        }

        public String getChargeId() {
            return chargeId;
        }

        public String getStatus() {
            return status;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "StripeTransacao{" +
                    "chargeId='" + chargeId + '\'' +
                    ", status='" + status + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }
}
