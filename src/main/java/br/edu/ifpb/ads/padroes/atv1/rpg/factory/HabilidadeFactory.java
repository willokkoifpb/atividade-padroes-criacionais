package br.edu.ifpb.ads.padroes.atv1.rpg.factory;

import br.edu.ifpb.ads.padroes.atv1.rpg.Habilidade;

/**
 * Classe que implementa o padrão Factory Method para criar
 * habilidades específicas.
 */
public class HabilidadeFactory {

    public static Habilidade criarHabilidade(String nomeHabilidade) {
        switch (nomeHabilidade.toLowerCase()) {
            // Habilidades de Guerreiro
            case "investida":
                return new Habilidade("Investida", "Ataque frontal violento", 20);
            case "bloqueio":
                return new Habilidade("Bloqueio", "Reduz dano recebido", 15);
            case "furia":
                return new Habilidade("Fúria", "Aumenta força temporariamente", 30);
            case "pancada_devastadora":
                return new Habilidade("Pancada Devastadora", "Golpe crítico poderoso", 40);
            case "danca_lâminas":
                return new Habilidade("Dança das Lâminas", "Ataque múltiplo rápido", 35);

            // Habilidades de Mago
            case "bola_fogo":
                return new Habilidade("Bola de Fogo", "Lança uma esfera de fogo", 50);
            case "cura":
                return new Habilidade("Cura", "Restaura vida", 60);
            case "magia_natureza":
                return new Habilidade("Magia da Natureza", "Magia das forças naturais", 55);
            case "teleporte":
                return new Habilidade("Teleporte", "Se move instantaneamente", 70);
            case "magia_sombria":
                return new Habilidade("Magia Sombria", "Magia das sombras", 45);
            case "invocacao":
                return new Habilidade("Invocação", "Invoca seres para ajudar", 80);

            // Habilidades de Arqueiro
            case "tiro_certeiro":
                return new Habilidade("Tiro Certeiro", "Dispara com precisão perfeita", 25);
            case "chuva_flechas":
                return new Habilidade("Chuva de Flechas", "Dispara múltiplas flechas", 40);
            case "tiro_multiplo":
                return new Habilidade("Tiro Múltiplo", "Dispara várias flechas ao mesmo alvo", 45);
            case "camuflagem":
                return new Habilidade("Camuflagem", "Se mistura com o ambiente", 30);

            // Habilidades raciais adicionais
            case "agilidade_elfica":
                return new Habilidade("Agilidade Élfica", "Aumenta agilidade permanentemente", 0);

            default:
                throw new IllegalArgumentException("Habilidade desconhecida: " + nomeHabilidade);
        }
    }
}
