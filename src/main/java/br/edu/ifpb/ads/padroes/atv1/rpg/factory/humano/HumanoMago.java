package br.edu.ifpb.ads.padroes.atv1.rpg.factory.humano;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;
import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;
import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta da Abstract Factory para Humano Mago
 */
public class HumanoMago implements ClasseEquipamentoFactory {

    @Override
    public Arma criarArma() {
        return EquipamentoFactory.criarArma("cajado_magico");
    }

    @Override
    public Armadura criarArmadura() {
        return EquipamentoFactory.criarArmadura("vestes_magicas");
    }

    @Override
    public Habilidade[] criarHabilidades() {
        return new Habilidade[]{
            HabilidadeFactory.criarHabilidade("bola_fogo"),
            HabilidadeFactory.criarHabilidade("cura")
        };
    }

    @Override
    public AtributoPersonagem criarAtributos() {
        return new AtributoPersonagem(6, 18, 8, 80, 150);
    }

    @Override
    public String getNomeClasse() {
        return "Mago";
    }
}
