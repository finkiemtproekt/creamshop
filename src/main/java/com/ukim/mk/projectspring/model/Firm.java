package com.ukim.mk.projectspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Firm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer firm_id;


    String firm_name;
    String firm_surname;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user_id;

    public Firm(Integer firm_id, String firm_name, String firm_surname, Users user_id) {
        this.firm_id = firm_id;
        this.firm_name = firm_name;
        this.firm_surname = firm_surname;
        this.user_id = user_id;
    }

    public Firm() {

    }

    public Integer getFirm_id() {
        return firm_id;
    }

    public void setFirm_id(Integer firm_id) {
        this.firm_id = firm_id;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public String getFirm_surname() {
        return firm_surname;
    }

    public void setFirm_surname(String firm_surname) {
        this.firm_surname = firm_surname;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }
}
