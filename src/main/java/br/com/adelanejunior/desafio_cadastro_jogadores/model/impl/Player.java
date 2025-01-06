package br.com.adelanejunior.desafio_cadastro_jogadores.model.impl;

import br.com.adelanejunior.desafio_cadastro_jogadores.model.BaseModel;
import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class Player implements BaseModel<Long>{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 70, nullable = false)
    private String email;

    @Column(name = "phone_number",length = 11 , nullable = false)
    private String phoneNumber;

    @Column(name = "nick_name",length = 50, nullable = false)
    private String nickName;

//    @ManyToOne
//    @JoinColumn(name = "team_id", nullable = false,
//            foreignKey = @ForeignKey(name = "fk_player_team"))
//    private Team team;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
