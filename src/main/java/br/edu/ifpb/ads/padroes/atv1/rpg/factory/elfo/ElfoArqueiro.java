package br.edu.ifpb.ads.padroes.atv1.rpg.factory.elfo;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Elfo Arqueiro
 */
public class ElfoArqueiro implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("arco_longo_elfico");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("armadura_couro_elfica");
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
        return new AtributoPersonagem(8, 16, 20, 90, 100);
    }

    @Override
    public String getNomeClasse() {
        return "Arqueiro";
    }
}
