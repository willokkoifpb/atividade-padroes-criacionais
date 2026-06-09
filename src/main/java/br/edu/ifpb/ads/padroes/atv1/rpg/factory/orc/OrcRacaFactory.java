package br.edu.ifpb.ads.padroes.atv1.rpg.factory.orc;

import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta do padrão Abstract Factory para a raça Orc.
 * Cria famílias de produtos (equipamentos e habilidades) para cada classe de orc.
 */
public class OrcRacaFactory implements RacaEquipamentoFactory {

    @Override
    public ClasseEquipamentoFactory criarGuerreiro() {
        return new OrcGuerreiro();
    }

    @Override
    public ClasseEquipamentoFactory criarMago() {
        return new OrcMago();
    }

    @Override
    public ClasseEquipamentoFactory criarArqueiro() {
        return new OrcArqueiro();
    }

    @Override
    public String getNomeRaca() {
        return "Orc";
    }
}
