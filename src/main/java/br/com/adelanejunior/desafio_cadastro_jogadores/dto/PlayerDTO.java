package br.com.adelanejunior.desafio_cadastro_jogadores.dto;

public class PlayerDTO {

    private String name;
    private String email;
    private String phoneNumber;
    private String nickName;
    private String teamId;

    public PlayerDTO() {
    }

    public PlayerDTO(String name, String email, String phoneNumber, String nickName, String teamId) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
        this.teamId = teamId;
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

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String team) {
        this.teamId = team;
    }
}