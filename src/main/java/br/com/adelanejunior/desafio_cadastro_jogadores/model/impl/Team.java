package br.com.adelanejunior.desafio_cadastro_jogadores.model.impl;

import br.com.adelanejunior.desafio_cadastro_jogadores.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "team")
public class Team implements BaseModel<Long> {

    @Id
    private Long id;

    @Column(name = "name", length = 50,
            unique = true, nullable = false)
    private String name;

    @Column(name = "url_endpoint", nullable = false, unique = true)
    private String urlEndPoint;

    public Team() {
    }

    public Team(Long id, String name, String urlEndPoint) {
        this.id = id;
        this.name = name;
        this.urlEndPoint = urlEndPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlEndPoint() {
        return urlEndPoint;
    }

    public void setUrlEndPoint(String urlEndPoint) {
        this.urlEndPoint = urlEndPoint;
    }
}
