package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.Constraint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstraintRepository extends JpaRepository<Constraint, Long> {
}
