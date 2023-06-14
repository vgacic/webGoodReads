package com.tim22.web.entity;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Autor")
@PrimaryKeyJoinColumn(name = "id")
public class Autor extends Korisnik implements Serializable {

    @Column
    private boolean aktivan;


    public boolean isAktivan() {
        return aktivan;
    }


    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

}
