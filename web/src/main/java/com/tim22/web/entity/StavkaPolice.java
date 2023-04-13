package com.tim22.web.entity;

import jakarta.persistence.*;

@Entity
public class StavkaPolice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //dodati objekat klase Recenzija
    @Column
    private Recenzija recenzija;
    //objekat klase Knjiga dodati


}
