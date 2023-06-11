package com.tim22.web.dto;

import com.tim22.web.entity.ZahtevZaAktivacijuNalogaAutora;

import java.util.Date;

public class ZahtevZaAktivacijuNalogaAutoraDto {
    private Long id;
    private String email;

    private int telefon;

    private String poruka;

    private Date datum;

    public ZahtevZaAktivacijuNalogaAutoraDto(ZahtevZaAktivacijuNalogaAutora zahtev) {
        this.id = zahtev.getId();
        this.email = zahtev.getEmail();
        this.telefon = zahtev.getTelefon();
        this.poruka = zahtev.getPoruka();
        this.datum = zahtev.getDatum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
