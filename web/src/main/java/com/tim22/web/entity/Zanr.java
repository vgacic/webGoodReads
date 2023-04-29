package com.tim22.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Zanr implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column
    private String naziv;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "knjiga_id", referencedColumnName = "id")
    private Knjiga knjiga;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
