package br.edu.ifpb.ads.padroes.atv1.rpg.factory.elfo;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Elfo Guerreiro
 */
public class ElfoGuerreiro implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("espada_elfica");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("cota_malha_elfica");
    }

    @Override
    public Habilidade[] criarHabilidades() {
        return new Habilidade[]{
            HabilidadeFactory.criarHabilidade("danca_lâminas"),
            HabilidadeFactory.criarHabilidade("agilidade_elfica")
        };
    }

    @Override
    public AtributoPersonagem criarAtributos() {
        return new AtributoPersonagem(12, 14, 16, 100, 60);
    }

    @Override
    public String getNomeClasse() {
        return "Guerreiro";
    }
}
