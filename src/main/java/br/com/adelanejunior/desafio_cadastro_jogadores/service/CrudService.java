package br.com.adelanejunior.desafio_cadastro_jogadores.service;

import br.com.adelanejunior.desafio_cadastro_jogadores.mapper.BaseMapper;
import br.com.adelanejunior.desafio_cadastro_jogadores.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudService<DTO, ENTITY extends BaseModel<TYPE_PK>, TYPE_PK,
        REPOSITORY extends JpaRepository<ENTITY, TYPE_PK>, MAPPER extends BaseMapper<DTO, ENTITY>>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected REPOSITORY repository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected MAPPER mapper;

    protected abstract void validations(DTO dto);

    public DTO create(DTO dto) {
        validations(dto);
        ENTITY entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    public List<DTO> listAll(){
        return mapper.toDTO(repository.findAll());
    }
}
