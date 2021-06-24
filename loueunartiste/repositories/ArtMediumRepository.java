package fr.formation.loueunartiste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.ArtMedium;

public interface ArtMediumRepository extends JpaRepository<ArtMedium, Long> {

}
