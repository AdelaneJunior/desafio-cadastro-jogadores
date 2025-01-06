package br.com.adelanejunior.desafio_cadastro_jogadores.mapper;

import java.util.List;

public interface BaseMapper<DTO, ENTITY> {

    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);
    List<DTO> toDTO(List<ENTITY> entitys);
    List<ENTITY> toEntity(List<DTO> dtos);
}
