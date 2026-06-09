package br.edu.ifpb.ads.padroes.atv1.rpg.factory;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;

/**
 * Interface que implementa o padrão Abstract Factory para criar
 * famílias de equipamentos e habilidades relacionados à classe do personagem.
 */
public interface ClasseEquipamentoFactory {

    Arma criarArma();

    Armadura criarArmadura();

    Habilidade[] criarHabilidades();

    AtributoPersonagem criarAtributos();

    String getNomeClasse();
}
