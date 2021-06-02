package com.proballbly.ProballblyApp.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @Column(name = "shortName")
    @Size(max=4)
    private String shortName;


    private String website;
    private String description;
    private String city;
    private String logo;
    private String arena;

    public Team() {
    }

    public Team(@NotEmpty String name, String shortName, String website, String description, String city, String logo, String arena) {
        this.name = name;
        this.shortName = shortName;
        this.website = website;
        this.description = description;
        this.city = city;
        this.logo = logo;
        this.arena = arena;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }
}
