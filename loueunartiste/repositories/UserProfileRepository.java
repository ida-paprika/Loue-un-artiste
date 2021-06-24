package fr.formation.loueunartiste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.UserProfile;

public interface UserProfileRepository
	extends JpaRepository<UserProfile, Long> {

}
