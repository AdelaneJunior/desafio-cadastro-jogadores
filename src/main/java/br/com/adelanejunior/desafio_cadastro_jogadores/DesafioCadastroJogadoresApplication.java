package br.com.adelanejunior.desafio_cadastro_jogadores;

import br.com.adelanejunior.desafio_cadastro_jogadores.model.impl.Team;
import br.com.adelanejunior.desafio_cadastro_jogadores.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DesafioCadastroJogadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCadastroJogadoresApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TeamRepository teamRepository) {
		return args -> {
			if (teamRepository.findByNameIgnoreCase("liga_da_justiça").isEmpty()){
				teamRepository.save(new Team(1L, "liga_da_justiça",
						"https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/" +
								"referencias/liga_da_justica.xml"));
			}
			if (teamRepository.findByNameIgnoreCase("vingadores").isEmpty()){
				teamRepository.save(new Team(2L, "vingadores",
						"https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/" +
								"referencias/vingadores.json"));
			}
		};
	}
}
