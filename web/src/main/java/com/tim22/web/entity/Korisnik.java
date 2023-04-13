package com.tim22.web.entity;
import jakarta.persistence.*;

import java.util.*;
@Entity
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;
    @Column
    private String prezime;

    @Column(unique = true)
    private String korisnickoIme; //jedinstveno?
    @Column(unique = true)
    private String mail; //jedinstvena?
    @Column
    private String lozinka;

    @Column
    private Date datumRodjenja; //ne znam da li mora date?

    @Column
    private String profilnaSlika; //string zbog putanje do slike?

    @Column
    private String opis;

    @Column
    private String uloga; //citalac, autor, administraror



    //nisam sigurna da li nam trebaju seteri za mail i korisnicko ime jer su jedinstveni????


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getProfilnaSlika() {
        return profilnaSlika;
    }

    public void setProfilnaSlika(String profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }


}
