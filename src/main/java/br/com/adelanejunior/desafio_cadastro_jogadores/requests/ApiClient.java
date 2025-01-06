package br.com.adelanejunior.desafio_cadastro_jogadores.requests;

import br.com.adelanejunior.desafio_cadastro_jogadores.ConversorType;
import br.com.adelanejunior.desafio_cadastro_jogadores.dto.TeamDTO;
import br.com.adelanejunior.desafio_cadastro_jogadores.model.impl.Team;
import br.com.adelanejunior.desafio_cadastro_jogadores.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiClient {

    private final TeamRepository teamRepository;

    public ApiClient(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamDTO getTeamByID(String id) {

        //TODO buscar a mensagem a partir de messages para localização e controle
        Team team = teamRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(team.getUrlEndPoint(),
                String.class);

        //TODO buscar a mensagem a partir de messages para localização e controle
        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
           throw new RuntimeException("Erro ao buscar dados das equipes");
        }

        return getTeamDTO(response, team);
    }

    private TeamDTO getTeamDTO(ResponseEntity<String> response, Team team) {
        TeamDTO teamDTO = ConversorType.valueOf(identifyFormat(response.getBody()))
                .convert(response.getBody());

        teamDTO.setId(teamDTO.getId());
        teamDTO.setName(team.getName());
        return teamDTO;
    }

    public String identifyFormat(String input) {
        if (input.trim().startsWith("<")) {
            return "XML";
        } else if (input.trim().startsWith("{") || input.trim().startsWith("[")) {
            return "JSON";
        } else {
            return "Unknown format";
        }
    }
}
