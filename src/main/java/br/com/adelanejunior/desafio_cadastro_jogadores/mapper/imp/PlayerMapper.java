package br.com.adelanejunior.desafio_cadastro_jogadores.mapper.imp;

import br.com.adelanejunior.desafio_cadastro_jogadores.dto.PlayerDTO;
import br.com.adelanejunior.desafio_cadastro_jogadores.mapper.BaseMapper;
import br.com.adelanejunior.desafio_cadastro_jogadores.model.impl.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper extends BaseMapper<PlayerDTO, Player> {
}
