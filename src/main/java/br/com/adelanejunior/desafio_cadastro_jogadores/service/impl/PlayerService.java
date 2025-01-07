package br.com.adelanejunior.desafio_cadastro_jogadores.service.impl;

import br.com.adelanejunior.desafio_cadastro_jogadores.dto.PlayerDTO;
import br.com.adelanejunior.desafio_cadastro_jogadores.dto.TeamDTO;
import br.com.adelanejunior.desafio_cadastro_jogadores.mapper.imp.PlayerMapper;
import br.com.adelanejunior.desafio_cadastro_jogadores.model.impl.Player;
import br.com.adelanejunior.desafio_cadastro_jogadores.repository.PlayerRepository;
import br.com.adelanejunior.desafio_cadastro_jogadores.requests.ApiClient;
import br.com.adelanejunior.desafio_cadastro_jogadores.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService extends CrudService<PlayerDTO, Player, Long, PlayerRepository, PlayerMapper> {

    private final ApiClient apiClient;

    public PlayerService(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    protected void validations(PlayerDTO playerDTO) {
        TeamDTO teamDTO = apiClient.getTeamByID(playerDTO.getTeamId());

        List<Player> players = repository.findAll();
        List<String> nickNamesUsed = players.stream().map(Player::getNickName).toList();

        //TODO buscar a mensagem a partir de messages para localização e controle
        String nickNameFree = teamDTO.getNickNames().stream().filter(nick -> !nickNamesUsed.contains(nick))
                .findFirst().orElseThrow(() -> new RuntimeException("Todos os codinomes dessa equipe estão em uso"));

        playerDTO.setNickName(nickNameFree);
    }


}
