package fr.formation.loueunartiste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.SocialInformation;

public interface SocialInformationRepository
	extends JpaRepository<SocialInformation, Long> {

}
