package fr.isep.homeexchangemanager.dao;

import fr.isep.homeexchangemanager.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
