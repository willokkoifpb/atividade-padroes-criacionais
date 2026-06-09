# Atividade 2 - Sistema de Processamento de Pagamentos com Injeção de Dependência

## Objetivo
Criar um sistema extensível de processamento de pagamentos que suporte múltiplos gateways de pagamento usando injeção de dependência com Pico Container.

## Estrutura do Projeto

### Pacotes

#### `atv2.gateway`
- **PayPalSDK**: Mock da API do PayPal
- **StripeSDK**: Mock da API do Stripe
- **PagSeguroSDK**: Mock da API do PagSeguro
- **PixSDK**: Mock da API do Pix (exemplo de extensão)

Implementações de `PagamentoGateway`:
- **PayPalGateway**: Wrapper que adapta PayPalSDK para a interface
- **StripeGateway**: Wrapper que adapta StripeSDK para a interface
- **PagSeguroGateway**: Wrapper que adapta PagSeguroSDK para a interface
- **PixGateway**: Exemplo de novo gateway adicionado (sem modificar código existente)

#### `atv2.core`
- **PagamentoGateway**: Interface abstrata que define o contrato
- **PagamentoService**: Serviço que usa injeção de dependência
- **ResultadoPagamento**: Classe para representar resultado de transações

#### `atv2.config`
- **PagamentoConfig**: Configuração de injeção de dependência com Pico Container

#### `atv2`
- **Main**: Classe principal que demonstra o uso do sistema

## Princípios Aplicados

### Single Responsibility Principle
- Cada classe tem uma responsabilidade única
- `PagamentoService` apenas coordena pagamentos
- Cada gateway cuidar da sua implementação específica

### Open/Closed Principle
- Sistema aberto para extensão (novos gateways)
- Fechado para modificação (PagamentoService não muda)
- Exemplo: `PixGateway` foi adicionado sem alterar código existente

### Dependency Inversion Principle
- `PagamentoService` depende da abstração `PagamentoGateway`
- Não depende de implementações concretas
- Facilita testes e trocas de implementação

### Interface Segregation Principle
- `PagamentoGateway` define apenas métodos necessários
- Não força implementações a ter métodos desnecessários

## Como Usar

```java
PagamentoConfig config = new PagamentoConfig();

// Criar serviço com PayPal
PagamentoService servicoPayPal = config.criarServiceComPayPal();
ResultadoPagamento resultado = servicoPayPal.pagar(150.00);

// Criar serviço com Stripe
PagamentoService servicoStripe = config.criarServiceComStripe();
resultado = servicoStripe.pagar(250.00);

// Criar serviço com PagSeguro
PagamentoService servicoPagSeguro = config.criarServiceComPagSeguro();
resultado = servicoPagSeguro.pagar(350.00);
```

## Como Adicionar um Novo Gateway

1. **Criar SDK Mock**:
```java
public class NovoGatewaySDK {
    public NovoGatewayTransacao processar(String... params) {
        // Implementar lógica
    }
}
```

2. **Implementar PagamentoGateway**:
```java
public class NovoGateway implements PagamentoGateway {
    private final NovoGatewaySDK sdk;
    
    public NovoGateway() { this.sdk = new NovoGatewaySDK(); }
    
    @Override
    public ResultadoPagamento processar(double valor) {
        // Implementar
    }
    
    @Override
    public String getNome() { return "NovoGateway"; }
}
```

3. **Registrar no PagamentoConfig**:
```java
public PagamentoService criarServiceComNovoGateway() {
    MutablePicoContainer container = new TransientPicoContainer();
    container.addComponent(PagamentoGateway.class, NovoGateway.class);
    container.addComponent(PagamentoService.class);
    return container.getComponent(PagamentoService.class);
}
```

## Executar

Compilar e executar `Main.java`:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ads.padroes.atv2.Main"
```

## Dependências

- **Pico Container 2.15.1**: Para injeção de dependência
- **Java 21+**: Versão mínima

## Padrões de Design Utilizados

1. **Dependency Injection**: Pico Container injeta `PagamentoGateway` em `PagamentoService`
2. **Adapter Pattern**: Cada gateway adapta seu SDK para a interface
3. **Strategy Pattern**: Diferentes estratégias de pagamento (PayPal, Stripe, PagSeguro, Pix)
4. **Factory Pattern**: `PagamentoConfig` cria instâncias configuradas
