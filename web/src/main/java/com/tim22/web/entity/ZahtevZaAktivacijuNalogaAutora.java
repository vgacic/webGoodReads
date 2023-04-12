package com.tim22.web.entity;
import java.util.*;
public class ZahtevZaAktivacijuNalogaAutora {
    private String email;

    private int telefon;

    private String poruka;

    private Date datum;

    enum status{NA_CEKANJU, ODOBREN, ODBIJEN};

    //nema getera i setera za status jel to postoji ?
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
