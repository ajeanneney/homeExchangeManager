package fr.isep.homeexchangemanager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

}
