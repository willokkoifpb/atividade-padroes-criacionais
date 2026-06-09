package br.edu.ifpb.ads.padroes.atv1.rpg.factory.orc;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Orc Mago
 * Nota: Não é uma combinação tradicional, mas o sistema permite.
 */
public class OrcMago implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("cajado_tribal");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("vestes_xamanicas");
    }

    @Override
    public Habilidade[] criarHabilidades() {
        return new Habilidade[]{
            HabilidadeFactory.criarHabilidade("magia_sombria"),
            HabilidadeFactory.criarHabilidade("invocacao")
        };
    }

    @Override
    public AtributoPersonagem criarAtributos() {
        return new AtributoPersonagem(10, 14, 6, 100, 120);
    }

    @Override
    public String getNomeClasse() {
        return "Mago";
    }
}
