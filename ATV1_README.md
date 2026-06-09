# Sistema de Criação de Personagens RPG - Padrões Criacionais

> Refatoração completa de um sistema legado aplicando os 5 padrões criacionais de projeto

## Visão Geral

Este projeto apresenta uma refatoração completa de um sistema de criação de personagens para um jogo RPG. O código original com muitos `if-else` aninhados foi transformado em uma solução elegante, extensível e testável utilizando **5 padrões criacionais**:

1. **Factory Method** - Criação de objetos através de métodos factory
2. **Abstract Factory** - Criação de famílias de produtos relacionados
3. **Builder** - Construção de objetos complexos de forma legível
4. **Singleton** - Garantir única instância de classe
5. **Prototype** - Clonagem de objetos existentes

## Características do Jogo

- **3 Raças**: Humano, Elfo, Orc
- **3 Classes**: Guerreiro, Mago, Arqueiro
- **9 Combinações**: Cada raça/classe com equipamentos e habilidades únicas
- **Atributos**: Força, Inteligência, Agilidade, Vida, Mana
- **Equipamentos**: Armas e armaduras específicas por classe

## Estrutura do Projeto

```
src/main/java/br/edu/ifpb/ads/padroes/atv1/rpg/
├── Personagem.java                    # Implementa Cloneable (Prototype)
├── Arma.java                          # Implementa Cloneable (Prototype)
├── Armadura.java                      # Implementa Cloneable (Prototype)
├── Habilidade.java                    # Classe para habilidades
├── CriadorPersonagem.java             # Orquestrador dos padrões
├── Main.java                          # Demonstração e testes
├── builder/
│   └── PersonagemBuilder.java         # Padrão Builder
├── factory/
│   ├── RacaFactory.java               # Factory Method
│   ├── RacaEquipamentoFactory.java     # Abstract Factory
│   ├── ClasseEquipamentoFactory.java   # Abstract Factory
│   ├── EquipamentoFactory.java         # Factory Method
│   ├── HabilidadeFactory.java          # Factory Method
│   ├── humano/                         # Implementações para Humano
│   ├── elfo/                           # Implementações para Elfo
│   └── orc/                            # Implementações para Orc
└── config/
    └── ConfiguracaoJogo.java           # Padrão Singleton
```

## Como Compilar

### Usando Maven
```bash
mvn clean compile
```

### Usando javac (sem Maven)
```bash
cd src/main/java
javac -source 1.8 -target 1.8 -d ../../../build/classes \
  -encoding UTF-8 \
  br/edu/ifpb/ads/padroes/atv1/rpg/*.java \
  br/edu/ifpb/ads/padroes/atv1/rpg/factory/*.java \
  br/edu/ifpb/ads/padroes/atv1/rpg/factory/humano/*.java \
  br/edu/ifpb/ads/padroes/atv1/rpg/factory/elfo/*.java \
  br/edu/ifpb/ads/padroes/atv1/rpg/factory/orc/*.java \
  br/edu/ifpb/ads/padroes/atv1/rpg/builder/*.java \
  br/edu/ifpb/ads/padroes/atv1/rpg/config/*.java
```

## Como Executar

```bash
java -cp build/classes br.edu.ifpb.ads.padroes.atv1.rpg.Main
```

### Saída Esperada
O programa demonstrará:
- ✅ Singleton funcionando
- ✅ Abstract Factory criando personagens
- ✅ Prototype clonando personagens
- ✅ Builder construindo personagens
- ✅ Factory Method criando equipamentos

## Exemplos de Uso

### Criar um personagem padrão
```java
Personagem heroi = CriadorPersonagem.criarPersonagem("Artur", "Humano", "Guerreiro");
System.out.println(heroi);
```

### Criar com Builder
```java
Personagem custom = new PersonagemBuilder("Aragorn")
    .comRaca("Humano")
    .comClasse("Guerreiro")
    .comForca(18)
    .comInteligencia(15)
    .comAgilidade(16)
    .comVida(150)
    .comMana(80)
    .build();
```

### Clonar um personagem
```java
Personagem original = CriadorPersonagem.criarPersonagem("Original", "Humano", "Mago");
Personagem clone = original.clone();
clone.setNome("Clone");
```

### Usar Singleton
```java
ConfiguracaoJogo config = ConfiguracaoJogo.getInstance();
config.setNivelDificuldade(7);
```

### Criar múltiplos clones
```java
String[] nomes = {"Clone1", "Clone2", "Clone3"};
Personagem[] clones = CriadorPersonagem.criarPersonagensClonados(original, nomes);
```

## Documentação

- **REFACTORING.md** - Explicação detalhada de cada padrão
- **DOCUMENTACAO_TECNICA.md** - Documentação técnica com exemplos
- **CHECKLIST.md** - Validação de todos os requisitos

## Padrões em Ação

### Factory Method
```java
// Criação centralizada
Arma espada = EquipamentoFactory.criarArma("espada_ferro");
Armadura armadura = EquipamentoFactory.criarArmadura("armadura_placas");
Habilidade habilidade = HabilidadeFactory.criarHabilidade("investida");
```

### Abstract Factory
```java
RacaEquipamentoFactory humanFactory = RacaFactory.criarRaca("Humano");
ClasseEquipamentoFactory guerreiro = humanFactory.criarGuerreiro();

// Todos os produtos são garantidamente compatíveis
Arma armaGuerreiro = guerreiro.criarArma();
Armadura armaGuerreiro = guerreiro.criarArmadura();
Habilidade[] skills = guerreiro.criarHabilidades();
```

### Builder
```java
Personagem hero = new PersonagemBuilder("Hero")
    .comRaca("Elfo")
    .comClasse("Arqueiro")
    .comForca(14)
    .comAgilidade(20)
    // ... mais atributos
    .build();
```

### Singleton
```java
ConfiguracaoJogo config1 = ConfiguracaoJogo.getInstance();
ConfiguracaoJogo config2 = ConfiguracaoJogo.getInstance();
// config1 == config2 (mesma instância)
```

### Prototype
```java
Personagem original = ...;
Personagem clon = original.clone(); // Deep copy
clon.setNome("Copy of " + original.getNome());
```

## Testes

Todos os padrões foram testados e validados:

- ✅ Compilação sem erros
- ✅ Execução sem exceções
- ✅ 9 combinações raça/classe funcionais
- ✅ Singleton retorna mesma instância
- ✅ Prototype clona corretamente
- ✅ Builder API fluida
- ✅ Abstract Factory produtos compatíveis
- ✅ Factory Method sem duplicação

## Aprendizados

Este projeto demonstra como padrões criacionais podem:

1. **Reduzir complexidade** - De 150+ linhas de if-else para código organizado
2. **Melhorar extensibilidade** - Adicionar novas raças/classes sem modificar código existente
3. **Facilitar testes** - Cada componente pode ser testado isoladamente
4. **Aumentar reusabilidade** - Componentes podem ser combinados de formas diferentes
5. **Melhorar legibilidade** - Cada classe tem responsabilidade clara

## Licença

Este é um projeto educacional desenvolvido como atividade acadêmica.

## Sobre

Refatoração de código legado aplicando padrões de projeto criacionais para demonstrar boas práticas de engenharia de software.
