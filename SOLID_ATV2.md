# SOLID e Padrões de Design na Atividade 2

## Princípios SOLID Aplicados

### S - Single Responsibility Principle

Cada classe tem **uma única responsabilidade**:

- **PayPalSDK**: Responsável apenas por simular chamadas à API PayPal
- **PayPalGateway**: Responsável apenas por adaptar PayPalSDK para a interface PagamentoGateway
- **PagamentoService**: Responsável apenas por coordenar pagamentos via gateway
- **PagamentoConfig**: Responsável apenas por configurar injeção de dependência
- **ResultadoPagamento**: Responsável apenas por representar resultado de transação

### O - Open/Closed Principle

Sistema é **aberto para extensão e fechado para modificação**:

```
✓ Aberto para extensão: Novos gateways podem ser adicionados
  - PixGateway foi adicionado sem modificar código existente
  - Qualquer novo gateway (Apple Pay, Google Pay) pode ser adicionado

✗ Fechado para modificação: PagamentoService não precisa mudar
  - PagamentoService não sabe qual gateway específico está usando
  - Continua funcionando com qualquer implementação de PagamentoGateway
```

**Exemplo**: Para adicionar Apple Pay:
```java
// 1. Criar ApplePaySDK (novo arquivo)
public class ApplePaySDK { }

// 2. Criar ApplePayGateway (novo arquivo) - implementa PagamentoGateway
public class ApplePayGateway implements PagamentoGateway { }

// 3. Adicionar método em PagamentoConfig
public PagamentoService criarServiceComApplePay() { }

// PagamentoService não é modificado! ✓
```

### L - Liskov Substitution Principle

Todas as implementações de `PagamentoGateway` são **intercambiáveis**:

```java
PagamentoGateway gateway1 = new PayPalGateway();
PagamentoGateway gateway2 = new StripeGateway();
PagamentoGateway gateway3 = new PixGateway();

// PagamentoService funciona com qualquer uma sem saber qual é
PagamentoService service = new PagamentoService(gateway1); // Funciona
service = new PagamentoService(gateway2); // Funciona
service = new PagamentoService(gateway3); // Funciona
```

Cada implementação:
- Respeita o contrato de `PagamentoGateway`
- Retorna `ResultadoPagamento` corretamente
- Possui mesmo comportamento esperado

### I - Interface Segregation Principle

Interfaces são **pequenas e específicas**:

```java
public interface PagamentoGateway {
    ResultadoPagamento processar(double valor);
    String getNome();
}
```

✓ Interface pequena com apenas 2 métodos
✓ Cada implementação tem o que precisa
✗ Não força métodos desnecessários (como refund, chargeBack)

### D - Dependency Inversion Principle

`PagamentoService` depende de **abstrações, não de implementações**:

```java
// ✓ Correto: depende de abstração
public class PagamentoService {
    private final PagamentoGateway gateway;  // Abstração!
    
    public PagamentoService(PagamentoGateway gateway) {
        this.gateway = gateway;
    }
}

// ✗ Errado (se fosse assim):
public class PagamentoService {
    private final PayPalGateway gateway;      // Implementação concreta!
    private final StripeGateway gateway2;     // Muitas dependências!
}
```

## Padrões de Design Utilizados

### 1. Dependency Injection (DI)

**Local**: `PagamentoService`, `PagamentoConfig`

```java
// PagamentoService recebe gateway via construtor
public PagamentoService(PagamentoGateway gateway) {
    this.gateway = gateway;
}

// PagamentoConfig injeta a dependência
MutablePicoContainer container = new TransientPicoContainer();
container.addComponent(PagamentoGateway.class, PayPalGateway.class);
container.addComponent(PagamentoService.class);
PagamentoService service = container.getComponent(PagamentoService.class);
```

**Benefício**: PagamentoService não cria seus próprios gateways, recebe do exterior

### 2. Adapter Pattern

**Local**: `PayPalGateway`, `StripeGateway`, `PagSeguroGateway`, `PixGateway`

```java
// Adapta SDK específico para interface PagamentoGateway
public class PayPalGateway implements PagamentoGateway {
    private final PayPalSDK sdk;
    
    @Override
    public ResultadoPagamento processar(double valor) {
        // Adapta resultado do SDK para ResultadoPagamento
        PayPalSDK.PayPalTransacao transacao = sdk.processarPagamento(...);
        return new ResultadoPagamento(
            transacao.getTransactionId(),
            transacao.getStatus(),
            transacao.getAmount(),
            getNome()
        );
    }
}
```

**Benefício**: Encapsula diferenças entre APIs diferentes

### 3. Strategy Pattern

**Local**: Múltiplas implementações de `PagamentoGateway`

```java
// Diferentes estratégias de pagamento
PagamentoGateway strategy1 = new PayPalGateway();
PagamentoGateway strategy2 = new StripeGateway();
PagamentoGateway strategy3 = new PixGateway();

// Cliente usa qualquer estratégia
PagamentoService service = new PagamentoService(strategy1);
```

**Benefício**: Trocar estratégia em tempo de execução

### 4. Factory Pattern

**Local**: `PagamentoConfig`

```java
public class PagamentoConfig {
    public PagamentoService criarServiceComPayPal() { }
    public PagamentoService criarServiceComStripe() { }
    public PagamentoService criarServiceComPagSeguro() { }
    public PagamentoService criarServiceComGateway(Class<?> gateway) { }
}
```

**Benefício**: Centraliza criação de objetos complexos

## Estrutura do Projeto

```
atv2/
├── gateway/
│   ├── PayPalSDK.java          (Mock SDK)
│   ├── StripeSDK.java          (Mock SDK)
│   ├── PagSeguroSDK.java       (Mock SDK)
│   ├── PixSDK.java             (Mock SDK - extensão)
│   ├── PayPalGateway.java      (Implementação)
│   ├── StripeGateway.java      (Implementação)
│   ├── PagSeguroGateway.java   (Implementação)
│   └── PixGateway.java         (Implementação - extensão)
│
├── core/
│   ├── PagamentoGateway.java   (Interface/Abstração)
│   ├── PagamentoService.java   (Serviço)
│   └── ResultadoPagamento.java (DTO)
│
├── config/
│   └── PagamentoConfig.java    (Configuração DI)
│
├── test/
│   └── PagamentoServiceTest.java (Testes)
│
├── Main.java                   (Demonstração básica)
└── MainComExtensao.java        (Demonstração com extensão)
```

## Como o Sistema é Extensível

### Adicionar novo gateway (ex: Apple Pay)

1. **Criar ApplePaySDK**: 
   - Arquivo novo: `ApplePaySDK.java`
   - PagamentoService não muda ✓

2. **Criar ApplePayGateway**:
   - Arquivo novo: `ApplePayGateway.java`
   - Implementa `PagamentoGateway`
   - PagamentoService não muda ✓

3. **Registrar em PagamentoConfig**:
   - Adiciona novo método `criarServiceComApplePay()`
   - Método em novo arquivo ✓

4. **Usar no Main**:
   - Chama `config.criarServiceComApplePay()`
   - PagamentoService não muda ✓

## Testabilidade

O sistema é facilmente testável graças à injeção de dependência:

```java
// Criar mock para testes
class GatewayMock implements PagamentoGateway {
    @Override
    public ResultadoPagamento processar(double valor) {
        return new ResultadoPagamento("MOCK_ID", "SUCESSO", valor, "Mock");
    }
    
    @Override
    public String getNome() { return "Mock"; }
}

// Usar com PagamentoService - sem modificar a classe!
PagamentoService service = new PagamentoService(new GatewayMock());
ResultadoPagamento resultado = service.pagar(100.00);
```