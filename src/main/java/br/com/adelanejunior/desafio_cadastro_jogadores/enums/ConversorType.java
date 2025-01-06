package br.com.adelanejunior.desafio_cadastro_jogadores.enums;

import br.com.adelanejunior.desafio_cadastro_jogadores.conversor.Conversor;
import br.com.adelanejunior.desafio_cadastro_jogadores.dto.TeamDTO;

import java.util.function.Function;

public enum ConversorType {

    JSON(Conversor::convertFromJson),
    XML(Conversor::convertFromXML);

    private final Function<String, TeamDTO> conversorStrategy;

    ConversorType(Function<String, TeamDTO> conversorStrategy){
        this.conversorStrategy = conversorStrategy;
    }

    public TeamDTO convert(String input){
        return conversorStrategy.apply(input);
    }
}
