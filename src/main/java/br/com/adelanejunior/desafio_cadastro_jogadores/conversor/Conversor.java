package br.com.adelanejunior.desafio_cadastro_jogadores.conversor;

import br.com.adelanejunior.desafio_cadastro_jogadores.dto.TeamDTO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;

public class Conversor {

    public static TeamDTO convertFromJson(String json){
        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        TeamDTO teamDTO = new TeamDTO();
        for (JsonElement element : jsonObject.getAsJsonArray("vingadores")) {
            teamDTO.getNickNames().add(gson.fromJson(element.getAsJsonObject().get("codinome"), String.class));
        }
        return teamDTO;
    }

    public static TeamDTO convertFromXML(String xml){
        try {
            JAXBContext context = JAXBContext.newInstance(TeamDTO.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
           return(TeamDTO) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
