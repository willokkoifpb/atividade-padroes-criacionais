package br.edu.ifpb.ads.padroes.atv1.rpg.factory.humano;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Humano Guerreiro
 */
public class HumanoGuerreiro implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("espada_ferro");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("armadura_placas");
    }

    @Override
    public Habilidade[] criarHabilidades() {
        return new Habilidade[]{
            HabilidadeFactory.criarHabilidade("investida"),
            HabilidadeFactory.criarHabilidade("bloqueio")
        };
    }

    @Override
    public AtributoPersonagem criarAtributos() {
        return new AtributoPersonagem(15, 8, 10, 120, 30);
    }

    @Override
    public String getNomeClasse() {
        return "Guerreiro";
    }
}
