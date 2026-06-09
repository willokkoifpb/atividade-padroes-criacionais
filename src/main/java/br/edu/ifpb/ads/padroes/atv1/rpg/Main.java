package br.edu.ifpb.ads.padroes.atv1.rpg;

import br.edu.ifpb.ads.padroes.atv1.rpg.config.ConfiguracaoJogo;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.RacaFactory;

/**
 * Classe Main que demonstra o uso de todos os padrões criacionais implementados:
 * - Factory Method (EquipamentoFactory, HabilidadeFactory, RacaFactory)
 * - Abstract Factory (RacaEquipamentoFactory, ClasseEquipamentoFactory)
 * - Builder (PersonagemBuilder)
 * - Singleton (ConfiguracaoJogo)
 * - Prototype (Personagem.clone())
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CRIAÇÃO DE PERSONAGENS RPG ===\n");

        // 1. Demonstração do padrão Singleton
        System.out.println("--- 1. SINGLETON: ConfiguracaoJogo ---");
        ConfiguracaoJogo config = ConfiguracaoJogo.getInstance();
        System.out.println("Nível de Dificuldade: " + config.getNivelDificuldade());
        config.setNivelDificuldade(5);
        
        // Obtém a mesma instância
        ConfiguracaoJogo config2 = ConfiguracaoJogo.getInstance();
        System.out.println("Nível de Dificuldade (após mudança): " + config2.getNivelDificuldade());
        System.out.println("São a mesma instância? " + (config == config2) + "\n");

        // 2. Demonstração do padrão Abstract Factory
        System.out.println("--- 2. ABSTRACT FACTORY: Criação de Personagens ---");
        Personagem humanoGuerreiro = CriadorPersonagem.criarPersonagem("Artur", "Humano", "Guerreiro");
        System.out.println("Criado: " + humanoGuerreiro + "\n");

        Personagem elfoMago = CriadorPersonagem.criarPersonagem("Legolas", "Elfo", "Mago");
        System.out.println("Criado: " + elfoMago + "\n");

        Personagem orcArqueiro = CriadorPersonagem.criarPersonagem("Durotan", "Orc", "Arqueiro");
        System.out.println("Criado: " + orcArqueiro + "\n");

        // 3. Demonstração do padrão Prototype (Clonagem)
        System.out.println("--- 3. PROTOTYPE: Clonagem de Personagens ---");
        Personagem clon1 = humanoGuerreiro.clone();
        clon1.setNome("Artur o Clone");
        System.out.println("Original: " + humanoGuerreiro);
        System.out.println("Clone: " + clon1);
        System.out.println("São objetos diferentes? " + (humanoGuerreiro != clon1) + "\n");

        // 4. Criação de múltiplos clones
        System.out.println("--- 4. PROTOTYPE: Criando múltiplos clones ---");
        String[] nomesClones = {"Artur Junior", "Artur Neto", "Artur Bisneto"};
        Personagem[] clones = CriadorPersonagem.criarPersonagensClonados(humanoGuerreiro, nomesClones);
        for (Personagem clone : clones) {
            System.out.println(clone);
        }
        System.out.println();

        // 5. Demonstração do padrão Builder
        System.out.println("--- 5. BUILDER: Criação Personalizada de Personagem ---");
        Personagem personagemCustomizado = CriadorPersonagem.criarPersonagemPersonalizado(
                "Aragorn", "Humano", "Guerreiro",
                18, 15, 16, 150, 80
        );
        System.out.println("Criado com Builder: " + personagemCustomizado + "\n");

        // 6. Demonstração de Factory Method para diferentes raças/classes
        System.out.println("--- 6. FACTORY METHOD: Criando várias combinações ---");
        String[] racas = RacaFactory.getRacasDisponiveis();
        String[] classes = RacaFactory.getClassesDisponiveis();

        System.out.println("Raças disponíveis: ");
        for (String raca : racas) {
            System.out.print(raca + " ");
        }
        System.out.println("\n");

        System.out.println("Classes disponíveis:");
        for (String classe : classes) {
            System.out.print(classe + " ");
        }
        System.out.println("\n");

        // Cria um personagem de cada raça e classe
        System.out.println("--- Personagens de exemplo ---");
        int contador = 1;
        for (String raca : racas) {
            for (String classe : classes) {
                Personagem p = CriadorPersonagem.criarPersonagem("Heroi" + contador, raca, classe);
                if (p != null) {
                    System.out.println(p);
                }
                contador++;
            }
        }
        System.out.println();

        // 7. Demonstração do padrão Prototype com Builder
        System.out.println("--- 7. PROTOTYPE + BUILDER: Combinação de Padrões ---");
        Personagem original = CriadorPersonagem.criarPersonagem("Originalis", "Humano", "Mago");
        System.out.println("Original: " + original);
        
        Personagem cloneModificado = original.clone();
        cloneModificado.setNome("Clone de Originalis");
        System.out.println("Clone Modificado: " + cloneModificado + "\n");

        System.out.println("=== FIM DA DEMONSTRAÇÃO ===");
    }
}
