package br.com.adelanejunior.desafio_cadastro_jogadores.repository;

import br.com.adelanejunior.desafio_cadastro_jogadores.model.impl.Player;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
