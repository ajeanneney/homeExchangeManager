package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.mail = :x")
    public User findByMail(@Param("x")String mail);


}
