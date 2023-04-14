package com.tim22.web.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;
@Entity
public class Recenzija implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ocena;
    private String tekst;

    private String datumRecenzije;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
    private Korisnik korisnik;

    @ManyToOne
    @JoinColumn(name = "stavkaPolice_id")
    private StavkaPolice stavkaPolice;


    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getDatumRecenzije() {
        return datumRecenzije;
    }

    public void setDatumRecenzije(String datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }
}
