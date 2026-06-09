# Atividades - Padrões de Projeto Criacionais e Estruturais

Este projeto contém duas atividades sobre padrões de projeto em Java.

## Estrutura Geral

```
atividade-padroes-criacionais/
├── pom.xml                          (Maven - agora com Pico Container)
├── README.md                        (Informações da Atividade 1)
├── respostas.txt                    (Respostas em formato de prova)
├── ATV2_README.md                   (Documentação da Atividade 2)
├── SOLID_ATV2.md                    (Explicação de SOLID e Padrões na Atividade 2)
│
└── src/main/java/br/edu/ifpb/ads/padroes/
    ├── atv1/                        (Atividade 1: Padrões Criacionais no RPG)
    │   └── rpg/
    │       ├── Main.java
    │       ├── Personagem.java
    │       ├── builder/
    │       │   └── PersonagemBuilder.java
    │       ├── factory/
    │       │   ├── RacaFactory.java
    │       │   ├── RacaEquipamentoFactory.java
    │       │   ├── ClasseEquipamentoFactory.java
    │       │   ├── ... (implementações por raça/classe)
    │       └── config/
    │           └── ConfiguracaoJogo.java
    │
    └── atv2/                        (Atividade 2: Pagamentos com Injeção de Dependência)
        ├── Main.java                (Demonstração básica)
        ├── MainComExtensao.java     (Com novo gateway Pix)
        ├── gateway/
        │   ├── PayPalSDK.java       (Mock SDK)
        │   ├── PayPalGateway.java   (Implementação)
        │   ├── StripeSDK.java       (Mock SDK)
        │   ├── StripeGateway.java   (Implementação)
        │   ├── PagSeguroSDK.java    (Mock SDK)
        │   ├── PagSeguroGateway.java (Implementação)
        │   ├── PixSDK.java          (Mock SDK - extensão)
        │   └── PixGateway.java      (Implementação - extensão)
        ├── core/
        │   ├── PagamentoGateway.java    (Abstração)
        │   ├── PagamentoService.java    (Serviço)
        │   └── ResultadoPagamento.java  (DTO)
        ├── config/
        │   └── PagamentoConfig.java     (Configuração DI)
        └── test/
            └── PagamentoServiceTest.java (Testes)
```

## Atividade 1: Padrões de Projeto Criacionais no RPG

**Objetivo**: Aplicar padrões criacionais (Builder, Factory, Singleton, Prototype) em um sistema de criação de personagens de RPG.

**Padrões Utilizados**:
- **Builder**: `PersonagemBuilder` - constrói personagens passo a passo
- **Abstract Factory**: `RacaEquipamentoFactory`, `ClasseEquipamentoFactory` - cria famílias de objetos por raça/classe
- **Factory Method**: `RacaFactory` - cria a factory correta para cada raça
- **Singleton**: `ConfiguracaoJogo` - única instância de configuração
- **Prototype**: `Personagem.clone()` - clona personagens existentes

**Princípios SOLID**:
- ✓ S: Cada classe tem responsabilidade única
- ✓ O: Aberto para extensão (novas raças/classes), fechado para modificação
- ✓ L: Classes de fábrica substituem interfaces corretamente
- ✓ I: Interfaces pequenas e específicas
- ✓ D: Depende de abstrações (`RacaEquipamentoFactory`), não de implementações

**Arquivos Principais**:
- [src/main/java/br/edu/ifpb/ads/padroes/atv1/rpg/CriadorPersonagem.java](src/main/java/br/edu/ifpb/ads/padroes/atv1/rpg/CriadorPersonagem.java)
- [src/main/java/br/edu/ifpb/ads/padroes/atv1/rpg/builder/PersonagemBuilder.java](src/main/java/br/edu/ifpb/ads/padroes/atv1/rpg/builder/PersonagemBuilder.java)
- [src/main/java/br/edu/ifpb/ads/padroes/atv1/rpg/factory/](src/main/java/br/edu/ifpb/ads/padroes/atv1/rpg/factory/)
- [respostas.txt](respostas.txt) - Respostas em formato de prova

---

## Atividade 2: Sistema de Processamento de Pagamentos com Injeção de Dependência

**Objetivo**: Criar um sistema extensível de processamento de pagamentos que suporte múltiplos gateways usando injeção de dependência.

**Requisitos Atendidos**:
- ✓ Mock SDKs para PayPal, Stripe, PagSeguro
- ✓ Abstração `PagamentoGateway`
- ✓ Classe `PagamentoService` com injeção de dependência
- ✓ Usa **Pico Container** (não Spring)
- ✓ Totalmente extensível (Pix adicionado como exemplo)
- ✓ PagamentoService não sofre modificações ao adicionar novos gateways

**Padrões de Design**:
- **Dependency Injection**: Via Pico Container
- **Adapter**: Gateways adaptam SDKs para interface comum
- **Strategy**: Diferentes estratégias de pagamento
- **Factory**: PagamentoConfig cria instâncias configuradas

**Princípios SOLID**:
- ✓ S: PagamentoService, gateways, SDKs com responsabilidades únicas
- ✓ O: Aberto para extensão (novos gateways), fechado para modificação (PagamentoService)
- ✓ L: Todos os gateways intercambiáveis
- ✓ I: Interface `PagamentoGateway` pequena e específica
- ✓ D: PagamentoService depende de `PagamentoGateway`, não de implementações

**Como Usar**:

```bash
# Compilar
mvn compile

# Executar demonstração básica
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ads.padroes.atv2.Main"

# Executar com extensão (Pix)
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ads.padroes.atv2.MainComExtensao"

# Executar testes
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ads.padroes.atv2.test.PagamentoServiceTest"
```

**Arquivos Principais**:
- [ATV2_README.md](ATV2_README.md) - Documentação completa
- [SOLID_ATV2.md](SOLID_ATV2.md) - Explicação de SOLID e padrões
- [src/main/java/br/edu/ifpb/ads/padroes/atv2/core/](src/main/java/br/edu/ifpb/ads/padroes/atv2/core/) - Abstrações e serviço
- [src/main/java/br/edu/ifpb/ads/padroes/atv2/gateway/](src/main/java/br/edu/ifpb/ads/padroes/atv2/gateway/) - Implementações de gateways
- [src/main/java/br/edu/ifpb/ads/padroes/atv2/config/](src/main/java/br/edu/ifpb/ads/padroes/atv2/config/) - Configuração DI

---

## Configuração e Dependências

### Java
- **Versão**: 21+
- **Encoding**: UTF-8

### Maven
```xml
<dependency>
    <groupId>org.picocontainer</groupId>
    <artifactId>picocontainer</artifactId>
    <version>2.15.1</version>
</dependency>
```

---

## Como Executar

### Atividade 1
```bash
mvn compile
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ads.padroes.atv1.rpg.Main"
```

### Atividade 2 - Básico
```bash
mvn compile
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ads.padroes.atv2.Main"
```

### Atividade 2 - Com Extensão (Pix)
```bash
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ads.padroes.atv2.MainComExtensao"
```

### Testes
```bash
mvn exec:java -Dexec.mainClass="br.edu.ifpb.ads.padroes.atv2.test.PagamentoServiceTest"
```

---

## Documentação Adicional

- [respostas.txt](respostas.txt) - Respostas sobre SOLID da Atividade 1 (formato de prova)
- [ATV2_README.md](ATV2_README.md) - Guia completo da Atividade 2
- [SOLID_ATV2.md](SOLID_ATV2.md) - Análise profunda de SOLID e padrões na Atividade 2

---

## Resumo dos Padrões Utilizados

| Padrão | Atividade | Classe(s) | Benefício |
|--------|-----------|-----------|----------|
| **Builder** | 1 | `PersonagemBuilder` | Construção flexível de objetos complexos |
| **Abstract Factory** | 1 | `RacaEquipamentoFactory`, `ClasseEquipamentoFactory` | Famílias de objetos relacionados |
| **Factory Method** | 1 | `RacaFactory` | Criação centralizada com polimorfismo |
| **Singleton** | 1 | `ConfiguracaoJogo` | Instância única global |
| **Prototype** | 1 | `Personagem.clone()` | Clonagem eficiente de objetos |
| **Dependency Injection** | 2 | `PagamentoService`, `PagamentoConfig` | Flexibilidade e testabilidade |
| **Adapter** | 2 | `PayPalGateway`, `StripeGateway`, etc. | Uniformidade de interface |
| **Strategy** | 2 | `PagamentoGateway` implementações | Múltiplas estratégias intercambiáveis |
| **Factory** | 2 | `PagamentoConfig` | Criação centralizada com configuração |

---

## Autor

José Wilson

Data: 2026-06-09
