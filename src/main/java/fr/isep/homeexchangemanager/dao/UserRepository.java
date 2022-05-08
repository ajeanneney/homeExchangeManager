package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
