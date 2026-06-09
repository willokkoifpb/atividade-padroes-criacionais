package br.edu.ifpb.ads.padroes.atv2.core;

/**
 * Classe que representa o resultado de um pagamento
 */
public class ResultadoPagamento {
    private String id;
    private String status;
    private double valor;
    private String gateway;

    public ResultadoPagamento(String id, String status, double valor, String gateway) {
        this.id = id;
        this.status = status;
        this.valor = valor;
        this.gateway = gateway;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public double getValor() {
        return valor;
    }

    public String getGateway() {
        return gateway;
    }

    public boolean isSucesso() {
        return "APPROVED".equals(status) || "PAID".equals(status) || "succeeded".equals(status);
    }

    @Override
    public String toString() {
        return "ResultadoPagamento{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", valor=" + valor +
                ", gateway='" + gateway + '\'' +
                '}';
    }
}
