package fr.formation.loueunartiste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.ArtFormat;
import fr.formation.loueunartiste.domain.entities.Artist;

public interface ArtFormatRepository extends JpaRepository<ArtFormat, Long> {

    List<ArtFormat> findByArtist(Artist artistEntity);

}
