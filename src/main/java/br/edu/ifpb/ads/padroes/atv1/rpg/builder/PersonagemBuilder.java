package br.edu.ifpb.ads.padroes.atv1.rpg.builder;

import br.edu.ifpb.ads.padroes.atv1.rpg.*;

/**
 * Implementação do padrão Builder para construir personagens de forma
 * flexível e legível, sem necessidade de muitos construtores sobrecarregados.
 */
public class PersonagemBuilder {

    private String nome;
    private String raca;
    private String classe;
    private int forca;
    private int inteligencia;
    private int agilidade;
    private int vida;
    private int mana;
    private Arma arma;
    private Armadura armadura;
    private String[] habilidades;

    public PersonagemBuilder(String nome) {
        this.nome = nome;
    }

    public PersonagemBuilder comRaca(String raca) {
        this.raca = raca;
        return this;
    }

    public PersonagemBuilder comClasse(String classe) {
        this.classe = classe;
        return this;
    }

    public PersonagemBuilder comForca(int forca) {
        this.forca = forca;
        return this;
    }

    public PersonagemBuilder comInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
        return this;
    }

    public PersonagemBuilder comAgilidade(int agilidade) {
        this.agilidade = agilidade;
        return this;
    }

    public PersonagemBuilder comVida(int vida) {
        this.vida = vida;
        return this;
    }

    public PersonagemBuilder comMana(int mana) {
        this.mana = mana;
        return this;
    }

    public PersonagemBuilder comArma(Arma arma) {
        this.arma = arma;
        return this;
    }

    public PersonagemBuilder comArmadura(Armadura armadura) {
        this.armadura = armadura;
        return this;
    }

    public PersonagemBuilder comHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
        return this;
    }

    public PersonagemBuilder comHabilidades(Habilidade[] habilidades) {
        if (habilidades != null) {
            this.habilidades = new String[habilidades.length];
            for (int i = 0; i < habilidades.length; i++) {
                this.habilidades[i] = habilidades[i].getNome();
            }
        }
        return this;
    }

    /**
     * Constrói o personagem com os atributos definidos.
     * Lança exceção se algum atributo obrigatório não foi definido.
     */
    public Personagem build() {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do personagem é obrigatório");
        }
        if (raca == null || raca.isEmpty()) {
            throw new IllegalArgumentException("Raça do personagem é obrigatória");
        }
        if (classe == null || classe.isEmpty()) {
            throw new IllegalArgumentException("Classe do personagem é obrigatória");
        }

        return new Personagem(nome, raca, classe, forca, inteligencia, agilidade,
                vida, mana, arma, armadura, habilidades);
    }

    /**
     * Constrói e clona o personagem (padrão Prototype)
     */
    public Personagem buildAndClone(Personagem template) {
        Personagem clonado = template.clone();
        clonado.setNome(this.nome);
        return clonado;
    }
}
