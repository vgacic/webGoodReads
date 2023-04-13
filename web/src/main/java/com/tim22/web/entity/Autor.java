package com.tim22.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Autor extends Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean aktivan;


    //popraviti
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Knjiga> SpisakKnjiga = new HashSet<>();



    public boolean isAktivan() {
        return aktivan;
    }


    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

}
