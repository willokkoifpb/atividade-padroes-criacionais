package br.edu.ifpb.ads.padroes.atv2.gateway;

/**
 * Mock SDK do PagSeguro - simula chamadas para a API do PagSeguro
 */
public class PagSeguroSDK {

    public PagSeguroSDK() {
        System.out.println("[PagSeguro SDK] Inicializado");
    }

    public PagSeguroTransacao processarPagamento(String email, String token, double valor) {
        System.out.println("[PagSeguro] Processando pagamento de R$ " + valor);
        System.out.println("[PagSeguro] Email: " + email);
        
        // Simula sucesso na transação
        return new PagSeguroTransacao(
            "PS_" + System.currentTimeMillis(),
            "PAID",
            valor
        );
    }

    public static class PagSeguroTransacao {
        private String codigoTransacao;
        private String status;
        private double valor;

        public PagSeguroTransacao(String codigoTransacao, String status, double valor) {
            this.codigoTransacao = codigoTransacao;
            this.status = status;
            this.valor = valor;
        }

        public String getCodigoTransacao() {
            return codigoTransacao;
        }

        public String getStatus() {
            return status;
        }

        public double getValor() {
            return valor;
        }

        @Override
        public String toString() {
            return "PagSeguroTransacao{" +
                    "codigoTransacao='" + codigoTransacao + '\'' +
                    ", status='" + status + '\'' +
                    ", valor=" + valor +
                    '}';
        }
    }
}
