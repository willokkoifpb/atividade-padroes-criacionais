package br.edu.ifpb.ads.padroes.atv1.rpg.config;

/**
 * Classe que implementa o padrão Singleton para gerenciar
 * a configuração global do jogo.
 */
public class ConfiguracaoJogo {

    private static ConfiguracaoJogo instancia;
    private int nivelDificuldade;
    private int idadeMinima;
    private int idadeMaxima;

    // Construtor privado para evitar instanciação direta
    private ConfiguracaoJogo() {
        this.nivelDificuldade = 1;
        this.idadeMinima = 18;
        this.idadeMaxima = 100;
    }

    /**
     * Retorna a única instância de ConfiguracaoJogo (padrão Singleton)
     */
    public static synchronized ConfiguracaoJogo getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracaoJogo();
        }
        return instancia;
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(int nivel) {
        if (nivel > 0 && nivel <= 10) {
            this.nivelDificuldade = nivel;
        }
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idade) {
        this.idadeMinima = idade;
    }

    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idade) {
        this.idadeMaxima = idade;
    }
}
