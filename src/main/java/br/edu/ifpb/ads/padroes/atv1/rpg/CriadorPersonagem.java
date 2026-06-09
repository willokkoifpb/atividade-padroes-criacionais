package br.edu.ifpb.ads.padroes.atv1.rpg;

import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;
import br.edu.ifpb.ads.padroes.atv1.rpg.builder.PersonagemBuilder;

/**
 * Classe que coordena a criação de personagens usando os padrões:
 * - Abstract Factory (para criar equipamentos e habilidades por raça/classe)
 * - Factory Method (para criar armas, armaduras e habilidades)
 * - Builder (para construir personagens de forma flexível)
 * - Singleton (ConfiguracaoJogo)
 * - Prototype (Personagem.clone())
 */
public class CriadorPersonagem {

    /**
     * Cria um personagem usando o padrão Abstract Factory.
     * Este método é a versão refatorada que utiliza todas as factories.
     */
    public static Personagem criarPersonagem(String nome, String raca, String classe) {
        try {
            // Obtém a Abstract Factory para a raça
            RacaEquipamentoFactory racaFactory = RacaFactory.criarRaca(raca);
            
            // Obtém a Abstract Factory para a classe dentro da raça
            ClasseEquipamentoFactory classeFactory;
            switch (classe.toLowerCase()) {
                case "guerreiro":
                    classeFactory = racaFactory.criarGuerreiro();
                    break;
                case "mago":
                    classeFactory = racaFactory.criarMago();
                    break;
                case "arqueiro":
                    classeFactory = racaFactory.criarArqueiro();
                    break;
                default:
                    throw new IllegalArgumentException("Classe desconhecida: " + classe);
            }

            // Obtém os atributos da combinação raça/classe
            AtributoPersonagem atributos = classeFactory.criarAtributos();

            // Usa o Builder para construir o personagem
            return new PersonagemBuilder(nome)
                    .comRaca(raca)
                    .comClasse(classe)
                    .comForca(atributos.getForca())
                    .comInteligencia(atributos.getInteligencia())
                    .comAgilidade(atributos.getAgilidade())
                    .comVida(atributos.getVida())
                    .comMana(atributos.getMana())
                    .comArma(classeFactory.criarArma())
                    .comArmadura(classeFactory.criarArmadura())
                    .comHabilidades(classeFactory.criarHabilidades())
                    .build();

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar personagem: " + e.getMessage());
            return null;
        }
    }

    /**
     * Cria um personagem especial através da clonagem de um personagem base
     * e personalização adicional usando o padrão Prototype.
     */
    public static Personagem criarPersonagemEspecial(String nome, String raca, String classe) {
        // Cria o personagem base
        Personagem base = criarPersonagem(nome, raca, classe);
        
        if (base == null) {
            return null;
        }

        // Clona o personagem base (padrão Prototype)
        Personagem especial = base.clone();
        especial.setNome(nome + " o Lendário");

        return especial;
    }

    /**
     * Cria um personagem personalizado usando o Builder Pattern.
     * Permite maior flexibilidade na criação.
     */
    public static Personagem criarPersonagemPersonalizado(String nome, String raca, String classe,
                                                         int forca, int inteligencia, int agilidade,
                                                         int vida, int mana) {
        return new PersonagemBuilder(nome)
                .comRaca(raca)
                .comClasse(classe)
                .comForca(forca)
                .comInteligencia(inteligencia)
                .comAgilidade(agilidade)
                .comVida(vida)
                .comMana(mana)
                .build();
    }

    /**
     * Cria múltiplos personagens clonando um personagem base.
     * Demonstra o uso do padrão Prototype.
     */
    public static Personagem[] criarPersonagensClonados(Personagem base, String[] nomes) {
        Personagem[] personagens = new Personagem[nomes.length];

        for (int i = 0; i < nomes.length; i++) {
            Personagem clonado = base.clone();
            clonado.setNome(nomes[i]);
            personagens[i] = clonado;
        }

        return personagens;
    }

}
