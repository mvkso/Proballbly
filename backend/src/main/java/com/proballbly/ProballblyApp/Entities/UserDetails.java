package com.proballbly.ProballblyApp.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @Column
    private String surname;

    @Column
    private Date birthday;

    @Column
    private Long phone;

    @JsonIgnore
    @OneToOne(mappedBy = "userDetails")
    private User user;

    public UserDetails() {

    }

    public UserDetails(String name, String surname, Date birthday, Long phone) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phone = phone;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
