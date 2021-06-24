package fr.formation.loueunartiste.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.Account;
import fr.formation.loueunartiste.domain.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    boolean existsByArtistName(String artistName);

    Artist findByAccount(Optional<Account> optional);

}
