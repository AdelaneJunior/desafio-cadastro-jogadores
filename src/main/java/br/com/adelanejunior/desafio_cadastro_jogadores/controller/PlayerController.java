package br.com.adelanejunior.desafio_cadastro_jogadores.controller;

import br.com.adelanejunior.desafio_cadastro_jogadores.dto.PlayerDTO;
import br.com.adelanejunior.desafio_cadastro_jogadores.service.impl.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("player", new PlayerDTO());
        return "create-player";
    }

    @PostMapping("/create")
    public String create(PlayerDTO player, Model model) {
        try {

            playerService.create(player);

            model.addAttribute("message", "Jogador cadastrado com sucesso!");
            model.addAttribute("messageType", "success");

        } catch (Exception e) {
            model.addAttribute("message", "Erro ao cadastrar jogador: " + e.getMessage());
            model.addAttribute("messageType", "error");
        }
        model.addAttribute("player", new PlayerDTO());
        return "create-player";
    }

    @GetMapping("/list")
    public ResponseEntity<List<PlayerDTO>> listAll() {
       return ResponseEntity.ok(playerService.listAll());
    }
}
