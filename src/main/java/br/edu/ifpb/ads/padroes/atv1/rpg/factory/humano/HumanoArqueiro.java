package br.edu.ifpb.ads.padroes.atv1.rpg.factory.humano;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Humano Arqueiro
 */
public class HumanoArqueiro implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("arco_elfico");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("armadura_couro");
    }

    @Override
    public Habilidade[] criarHabilidades() {
        return new Habilidade[]{
            HabilidadeFactory.criarHabilidade("tiro_certeiro"),
            HabilidadeFactory.criarHabilidade("chuva_flechas")
        };
    }

    @Override
    public AtributoPersonagem criarAtributos() {
        return new AtributoPersonagem(10, 12, 16, 100, 70);
    }

    @Override
    public String getNomeClasse() {
        return "Arqueiro";
    }
}
