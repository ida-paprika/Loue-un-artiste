package fr.formation.loueunartiste.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loueunartiste.domain.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<Account> findByUsernameAndEnabledTrue(String username);

}
