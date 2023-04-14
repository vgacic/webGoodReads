package com.tim22.web.entity;
import jakarta.persistence.*;

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

    private String datum;

    @Enumerated(EnumType.STRING)
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

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
