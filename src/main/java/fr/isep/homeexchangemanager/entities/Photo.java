package fr.isep.homeexchangemanager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Photo implements Serializable {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "houseId")
    private House house;

    private String url;
}
