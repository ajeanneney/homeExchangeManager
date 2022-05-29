package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.House;
import fr.isep.homeexchangemanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.RouteMatcher;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("select h from House h where h.owner = :x")
    public List<House> findByOwner(@Param("x")User owner);

    @Query("select h from House h where h.owner <> :x")
    public List<House> findAllExeptCurentUser(@Param("x")User user);

    public List<House> findByTitleContainingIgnoreCase(String title);
}
