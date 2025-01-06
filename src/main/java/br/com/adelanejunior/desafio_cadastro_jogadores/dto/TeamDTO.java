package br.com.adelanejunior.desafio_cadastro_jogadores.dto;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class TeamDTO {

    private int id;
    private String name;

    @XmlElement(name = "codinome")
    @SerializedName("codinome")
    private List<String> nickNames;

    public TeamDTO(){

    }

    public TeamDTO(int id, String name, List<String> nickNames) {
        this.id = id;
        this.name = name;
        this.nickNames = nickNames;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(List<String> nickNames) {
        this.nickNames = nickNames;
    }


}
