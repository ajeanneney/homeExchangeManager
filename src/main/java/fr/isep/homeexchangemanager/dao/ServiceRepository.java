package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
