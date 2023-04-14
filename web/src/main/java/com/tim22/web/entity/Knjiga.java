package com.tim22.web.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;
@Entity
public class Knjiga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naslov;
    private String naslovnaFotografija;

    @Column(unique = true)
    private String ISBN;

    @Column
    private String datumObjavljivanja;

    @Column
    private int brojStrana;
    @Column
    private String opis;
    @Column

    private String zanr;
    @Column
    private double ocena;

   @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StavkaPolice stavkaPolice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Autor autor;


    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        this.naslovnaFotografija = naslovnaFotografija;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(String datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }
}
