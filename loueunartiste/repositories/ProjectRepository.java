package fr.formation.loueunartiste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
