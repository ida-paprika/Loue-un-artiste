package fr.formation.loueunartiste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.ArtFormat;

public interface ArtFormatRepository extends JpaRepository<ArtFormat, Long> {

}
