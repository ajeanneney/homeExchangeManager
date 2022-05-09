package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
