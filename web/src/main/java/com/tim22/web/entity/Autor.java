package com.tim22.web.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class Autor extends Korisnik{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean aktivan;



   // private HashMap<Knjiga> SpisakKnjiga=new ArrayList<>();


    public boolean isAktivan() {
        return aktivan;
    }


    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }


    //public ArrayList<String> getSpisakKnjiga() {
     //   return SpisakKnjiga;
   // }
}
