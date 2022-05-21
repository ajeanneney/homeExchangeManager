package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.House;
import fr.isep.homeexchangemanager.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("select p from Photo p where p.house = :x")
    public Photo[] findByHouse(@Param("x")House house);

}
