package br.edu.ifpb.ads.padroes.atv1.rpg.factory.orc;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Orc Arqueiro
 */
public class OrcArqueiro implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("arco_tribal");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("armadura_brutal");
    }

    @Override
    public Habilidade[] criarHabilidades() {
        return new Habilidade[]{
            HabilidadeFactory.criarHabilidade("tiro_multiplo"),
            HabilidadeFactory.criarHabilidade("camuflagem")
        };
    }

    @Override
    public AtributoPersonagem criarAtributos() {
        return new AtributoPersonagem(14, 8, 12, 110, 60);
    }

    @Override
    public String getNomeClasse() {
        return "Arqueiro";
    }
}
