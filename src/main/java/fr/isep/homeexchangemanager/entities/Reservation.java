package fr.isep.homeexchangemanager.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Reservation implements Serializable {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "houseId")
    private House house;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "tenantUserId")
    private User tenantUser;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date endDate;

    private Boolean isValidated;

    public Reservation() {
    }

    public Reservation(House house, User tenantUser, Date startDate, Date endDate, Boolean isValidated) {
        this.house = house;
        this.tenantUser = tenantUser;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isValidated = isValidated;
    }

    public Boolean getValidated() {
        return isValidated;
    }

    public void setValidated(Boolean validated) {
        isValidated = validated;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public User getTenantUser() {
        return tenantUser;
    }

    public void setTenantUser(User tenantUser) {
        this.tenantUser = tenantUser;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
