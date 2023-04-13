package com.tim22.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StavkaPolice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //dodati objekat klase Recenzija
    @Column
    private Recenzija recenzija;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Polica polica;

    @OneToMany(mappedBy = "stavkaPolice",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Knjiga> knjige= new HashSet<>();

    @OneToMany
    private Set<Recenzija> recenzije = new HashSet<>();


}
