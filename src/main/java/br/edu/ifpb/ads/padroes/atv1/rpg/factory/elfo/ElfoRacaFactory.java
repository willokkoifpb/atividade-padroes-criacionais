package br.edu.ifpb.ads.padroes.atv1.rpg.factory.elfo;

import br.edu.ifpb.ads.padroes.atv1.rpg.factory.*;

/**
 * Implementação concreta do padrão Abstract Factory para a raça Elfo.
 * Cria famílias de produtos (equipamentos e habilidades) para cada classe de elfo.
 */
public class ElfoRacaFactory implements RacaEquipamentoFactory {

    @Override
    public ClasseEquipamentoFactory criarGuerreiro() {
        return new ElfoGuerreiro();
    }

    @Override
    public ClasseEquipamentoFactory criarMago() {
        return new ElfoMago();
    }

    @Override
    public ClasseEquipamentoFactory criarArqueiro() {
        return new ElfoArqueiro();
    }

    @Override
    public String getNomeRaca() {
        return "Elfo";
    }
}
