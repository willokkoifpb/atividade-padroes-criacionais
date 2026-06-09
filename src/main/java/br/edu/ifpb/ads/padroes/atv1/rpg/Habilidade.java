package br.edu.ifpb.ads.padroes.atv1.rpg;

/**
 * Classe que representa uma habilidade especial de um personagem.
 */
public class Habilidade implements Cloneable {

    private String nome;
    private String descricao;
    private int custoMana;

    public Habilidade(String nome, String descricao, int custoMana) {
        this.nome = nome;
        this.descricao = descricao;
        this.custoMana = custoMana;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCustoMana() {
        return custoMana;
    }

    @Override
    public Habilidade clone() {
        try {
            return (Habilidade) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar habilidade", e);
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}
