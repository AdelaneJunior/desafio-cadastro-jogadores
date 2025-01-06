package br.com.adelanejunior.desafio_cadastro_jogadores.conversor;

import br.com.adelanejunior.desafio_cadastro_jogadores.dto.TeamDTO;

public class Conversor {

    public static TeamDTO convertFromJson(String text){
        return new TeamDTO();
    }

    public static TeamDTO convertFromXML(String text){
        return new TeamDTO();
    }
}
