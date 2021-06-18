package fr.formation.loueunartiste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
