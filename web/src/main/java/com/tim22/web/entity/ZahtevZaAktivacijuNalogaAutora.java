package com.tim22.web.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.*;
enum status{NA_CEKANJU, ODOBREN, ODBIJEN};
@Entity
public class ZahtevZaAktivacijuNalogaAutora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    private int telefon;

    private String poruka;

    private Date datum;

    private status stanje;


    public Long getId() {
        return id;
    }

    public status getStanje() {
        return stanje;
    }

    public void setStanje(status stanje) {
        this.stanje = stanje;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
