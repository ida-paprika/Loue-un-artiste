package fr.formation.loueunartiste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.ArtMedium;
import fr.formation.loueunartiste.domain.entities.Artist;

public interface ArtMediumRepository extends JpaRepository<ArtMedium, Long> {

    List<ArtMedium> findByArtist(Artist artistEntity);

}
