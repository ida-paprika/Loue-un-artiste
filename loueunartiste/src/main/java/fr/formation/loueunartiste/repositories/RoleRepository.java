package fr.formation.loueunartiste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByByDefaultTrue();

    Role findByCodeContaining(String string);

    Role findByCode(String string);

}
