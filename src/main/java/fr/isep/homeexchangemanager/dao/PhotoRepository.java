package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
