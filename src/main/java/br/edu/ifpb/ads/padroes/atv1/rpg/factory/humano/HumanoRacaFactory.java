package br.edu.ifpb.ads.padroes.atv1.rpg.factory.humano;

import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta do padrão Abstract Factory para a raça Humano.
 * Cria famílias de produtos (equipamentos e habilidades) para cada classe de humano.
 */
public class HumanoRacaFactory implements RacaEquipamentoFactory {

    @Override
    public ClasseEquipamentoFactory criarGuerreiro() {
        return new HumanoGuerreiro();
    }

    @Override
    public ClasseEquipamentoFactory criarMago() {
        return new HumanoMago();
    }

    @Override
    public ClasseEquipamentoFactory criarArqueiro() {
        return new HumanoArqueiro();
    }

    @Override
    public String getNomeRaca() {
        return "Humano";
    }
}
