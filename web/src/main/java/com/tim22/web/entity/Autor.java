package com.tim22.web.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Autor")
@PrimaryKeyJoinColumn(name = "id")
public class Autor extends Korisnik implements Serializable {

    @Column
    private boolean aktivan;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Knjiga> SpisakKnjiga = new HashSet<>();



    public boolean isAktivan() {
        return aktivan;
    }


    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

}
