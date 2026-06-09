package br.edu.ifpb.ads.padroes.atv1.rpg.factory;

import br.edu.ifpb.ads.padroes.atv1.rpg.factory.humano.HumanoRacaFactory;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.elfo.ElfoRacaFactory;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.orc.OrcRacaFactory;

/**
 * Factory que implementa o Factory Method Pattern para criar as Abstract Factories
 * de cada raça. Centraliza a criação das raças.
 */
public class RacaFactory {

    /**
     * Factory Method para criar a Abstract Factory apropriada para cada raça
     */
    public static RacaEquipamentoFactory criarRaca(String nomeRaca) {
        switch (nomeRaca.toLowerCase()) {
            case "humano":
                return new HumanoRacaFactory();
            case "elfo":
                return new ElfoRacaFactory();
            case "orc":
                return new OrcRacaFactory();
            default:
                throw new IllegalArgumentException("Raça desconhecida: " + nomeRaca);
        }
    }

    /**
     * Retorna um array com as raças disponíveis
     */
    public static String[] getRacasDisponiveis() {
        return new String[]{"Humano", "Elfo", "Orc"};
    }

    /**
     * Retorna um array com as classes disponíveis
     */
    public static String[] getClassesDisponiveis() {
        return new String[]{"Guerreiro", "Mago", "Arqueiro"};
    }
}
