package br.com.adelanejunior.desafio_cadastro_jogadores.dto;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "liga_da_justica")
public class TeamDTO {

    private int id;
    private String name;

    @XmlElementWrapper(name = "codinomes")
    @XmlElement(name = "codinome")
    @SerializedName("codinome")
    private List<String> nickNames = new ArrayList<>();

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
