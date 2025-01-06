package br.com.adelanejunior.desafio_cadastro_jogadores.model;

public interface BaseModel<TYPE_PK> {
    public TYPE_PK getId();
    public void setId(TYPE_PK id);
}
