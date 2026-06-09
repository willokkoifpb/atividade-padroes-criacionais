package br.edu.ifpb.ads.padroes.atv1.rpg.factory;

import br.edu.ifpb.ads.padroes.atv1.rpg.Arma;
import br.edu.ifpb.ads.padroes.atv1.rpg.Armadura;

/**
 * Classe que implementa o padrão Factory Method para criar
 * armas e armaduras específicas por tipo.
 */
public class EquipamentoFactory {

    /**
     * Factory Method para criar armas
     */
    public static Arma criarArma(String tipoArma) {
        switch (tipoArma.toLowerCase()) {
            case "espada_ferro":
                return new Arma("Espada de Ferro", 25, "Espada");
            case "espada_elfica":
                return new Arma("Lâmina Élfica", 22, "Espada");
            case "machado_guerra":
                return new Arma("Machado de Guerra", 30, "Machado");
            case "arco_elfico":
                return new Arma("Arco Élfico", 20, "Arco");
            case "arco_longo_elfico":
                return new Arma("Arco Longo Élfico", 28, "Arco");
            case "arco_tribal":
                return new Arma("Arco Tribal Orc", 24, "Arco");
            case "cajado_magico":
                return new Arma("Cajado Mágico", 15, "Cajado");
            case "cajado_natureza":
                return new Arma("Cajado da Natureza", 18, "Cajado");
            case "cajado_tribal":
                return new Arma("Cajado Tribal", 12, "Cajado");
            default:
                throw new IllegalArgumentException("Tipo de arma desconhecido: " + tipoArma);
        }
    }

    /**
     * Factory Method para criar armaduras
     */
    public static Armadura criarArmadura(String tipoArmadura) {
        switch (tipoArmadura.toLowerCase()) {
            case "armadura_placas":
                return new Armadura("Armadura de Placas", 20, "Pesada");
            case "cota_malha_elfica":
                return new Armadura("Cota de Malha Élfica", 15, "Média");
            case "armadura_brutal":
                return new Armadura("Armadura Brutal", 25, "Pesada");
            case "armadura_couro":
                return new Armadura("Armadura de Couro", 12, "Média");
            case "armadura_couro_elfica":
                return new Armadura("Armadura de Couro Élfico", 14, "Média");
            case "vestes_magicas":
                return new Armadura("Vestes Mágicas", 8, "Leve");
            case "mantos_elficos":
                return new Armadura("Mantos Élficos", 10, "Leve");
            case "vestes_xamanicas":
                return new Armadura("Vestes Xamânicas", 6, "Leve");
            default:
                throw new IllegalArgumentException("Tipo de armadura desconhecido: " + tipoArmadura);
        }
    }
}
