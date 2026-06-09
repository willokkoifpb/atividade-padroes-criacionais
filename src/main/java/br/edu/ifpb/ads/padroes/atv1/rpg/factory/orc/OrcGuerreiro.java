package br.edu.ifpb.ads.padroes.atv1.rpg.factory.orc;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Orc Guerreiro
 */
public class OrcGuerreiro implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("machado_guerra");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("armadura_brutal");
    }

    @Override
    public Habilidade[] criarHabilidades() {
        return new Habilidade[]{
            HabilidadeFactory.criarHabilidade("furia"),
            HabilidadeFactory.criarHabilidade("pancada_devastadora")
        };
    }

    @Override
    public AtributoPersonagem criarAtributos() {
        return new AtributoPersonagem(20, 6, 8, 150, 20);
    }

    @Override
    public String getNomeClasse() {
        return "Guerreiro";
    }
}
