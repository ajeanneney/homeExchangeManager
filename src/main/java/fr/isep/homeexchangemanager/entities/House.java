package fr.isep.homeexchangemanager.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
public class House implements Serializable {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ownerId")
    private User owner;
    private String title;
    private String description;

    @OneToMany(mappedBy="house")
    private List<Photo> photos;

    @ManyToMany
    private List<Service> services;

    @ManyToMany
    private List<Necessity> necessities;

    public List<Necessity> getNecessities() {
        return necessities;
    }

    public void setNecessities(List<Necessity> necessities) {
        this.necessities = necessities;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public House() {
    }

    public House(User owner, String title, String description) {
        this.owner = owner;
        this.title = title;
        this.description = description;
    }

    public House(User owner, String title, String description, List<Service> services, List<Necessity> necessities) {
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.services = services;
        this.necessities = necessities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
