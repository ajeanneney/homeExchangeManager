package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.Necessity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NecessityRepository extends JpaRepository<Necessity, Long> {


}
