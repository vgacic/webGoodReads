package com.tim22.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private boolean primarna;

    @OneToMany(mappedBy = "polica", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StavkaPolice> stavkaPolice = new HashSet<>();



    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isPrimarna() {
        return primarna;
    }

    public void setPrimarna(boolean primarna) {
        this.primarna = primarna;
    }
}
