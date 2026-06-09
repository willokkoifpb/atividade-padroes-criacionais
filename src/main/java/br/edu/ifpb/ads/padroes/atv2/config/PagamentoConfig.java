package br.edu.ifpb.ads.padroes.atv2.config;

import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;
import org.picocontainer.containers.TransientPicoContainer;

import br.edu.ifpb.ads.padroes.atv2.core.PagamentoGateway;
import br.edu.ifpb.ads.padroes.atv2.core.PagamentoService;
import br.edu.ifpb.ads.padroes.atv2.gateway.PayPalGateway;
import br.edu.ifpb.ads.padroes.atv2.gateway.StripeGateway;
import br.edu.ifpb.ads.padroes.atv2.gateway.PagSeguroGateway;

/**
 * Configuração de injeção de dependência usando Pico Container.
 * Centraliza a criação e configuração de objetos.
 */
public class PagamentoConfig {

    private final MutablePicoContainer pico;

    public PagamentoConfig() {
        this.pico = new TransientPicoContainer();
    }

    /**
     * Configura o container com PayPal como gateway
     */
    public PagamentoService criarServiceComPayPal() {
        MutablePicoContainer container = new TransientPicoContainer();
        container.addComponent(PagamentoGateway.class, PayPalGateway.class);
        container.addComponent(PagamentoService.class);
        return container.getComponent(PagamentoService.class);
    }

    /**
     * Configura o container com Stripe como gateway
     */
    public PagamentoService criarServiceComStripe() {
        MutablePicoContainer container = new TransientPicoContainer();
        container.addComponent(PagamentoGateway.class, StripeGateway.class);
        container.addComponent(PagamentoService.class);
        return container.getComponent(PagamentoService.class);
    }

    /**
     * Configura o container com PagSeguro como gateway
     */
    public PagamentoService criarServiceComPagSeguro() {
        MutablePicoContainer container = new TransientPicoContainer();
        container.addComponent(PagamentoGateway.class, PagSeguroGateway.class);
        container.addComponent(PagamentoService.class);
        return container.getComponent(PagamentoService.class);
    }

    /**
     * Configura o container com um gateway customizado
     */
    public PagamentoService criarServiceComGateway(Class<? extends PagamentoGateway> gatewayClass) {
        MutablePicoContainer container = new TransientPicoContainer();
        container.addComponent(PagamentoGateway.class, gatewayClass);
        container.addComponent(PagamentoService.class);
        return container.getComponent(PagamentoService.class);
    }
}
