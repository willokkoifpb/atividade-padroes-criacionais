package br.edu.ifpb.ads.padroes.atv1.rpg.factory;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;

/**
 * Interface que implementa o padrão Abstract Factory para criar
 * famílias de equipamentos e habilidades relacionados à raça do personagem.
 */
public interface RacaEquipamentoFactory {

    ClasseEquipamentoFactory criarGuerreiro();

    ClasseEquipamentoFactory criarMago();

    ClasseEquipamentoFactory criarArqueiro();

    String getNomeRaca();
}
