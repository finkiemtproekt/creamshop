package com.ukim.mk.projectspring.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cream_id;

    String cream_name;
    String cream_year;

    @ManyToOne
    @JoinColumn(name = "firm_id", referencedColumnName = "firm_id")
    private Firm firm;

    public Cream(Integer cream_id, String cream_name, String cream_year, Firm firm) {
        this.cream_id = cream_id;
        this.cream_name = cream_name;
        this.cream_year = cream_year;
        this.firm = firm;
    }

    public Cream() {
    }

    public Integer getCream_id() {
        return cream_id;
    }

    public void setCream_id(Integer cream_id) {
        this.cream_id = cream_id;
    }

    public String getCream_name() {
        return cream_name;
    }

    public void setCream_name(String cream_name) {
        this.cream_name = cream_name;
    }

    public String getCream_year() {
        return cream_year;
    }

    public void setCream_year(String cream_year) {
        this.cream_year = cream_year;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }
}
