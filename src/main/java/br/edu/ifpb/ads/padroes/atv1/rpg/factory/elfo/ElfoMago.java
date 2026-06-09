package br.edu.ifpb.ads.padroes.atv1.rpg.factory.elfo;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Elfo Mago
 */
public class ElfoMago implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("cajado_natureza");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("mantos_elficos");
    }

    @Override
    public Habilidade[] criarHabilidades() {
        return new Habilidade[]{
            HabilidadeFactory.criarHabilidade("magia_natureza"),
            HabilidadeFactory.criarHabilidade("teleporte")
        };
    }

    @Override
    public AtributoPersonagem criarAtributos() {
        return new AtributoPersonagem(4, 20, 14, 70, 180);
    }

    @Override
    public String getNomeClasse() {
        return "Mago";
    }
}
