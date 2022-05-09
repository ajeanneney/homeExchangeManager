package fr.isep.homeexchangemanager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reservation implements Serializable {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "houseId")
    private House house;

    @ManyToOne
    @JoinColumn(name = "tenantUserId")
    private User tenantUser;
}
