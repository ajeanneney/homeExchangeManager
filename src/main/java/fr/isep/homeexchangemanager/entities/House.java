package fr.isep.homeexchangemanager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class House implements Serializable {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User owner;

    private String title;
    private String description;
}
