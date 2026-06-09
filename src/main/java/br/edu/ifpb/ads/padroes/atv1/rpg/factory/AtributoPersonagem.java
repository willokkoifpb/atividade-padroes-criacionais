package br.edu.ifpb.ads.padroes.atv1.rpg.factory;

/**
 * Classe que encapsula os atributos de um personagem.
 */
public class AtributoPersonagem {

    private int forca;
    private int inteligencia;
    private int agilidade;
    private int vida;
    private int mana;

    public AtributoPersonagem(int forca, int inteligencia, int agilidade, int vida, int mana) {
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.agilidade = agilidade;
        this.vida = vida;
        this.mana = mana;
    }

    public int getForca() {
        return forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }
}
