package com.tim22.web.entity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Autor")
@PrimaryKeyJoinColumn(name = "id")
public class Autor extends Korisnik implements Serializable {

    @Column
    private boolean aktivan;

    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Set<Knjiga>spisakKnjiga;



    public Set<Knjiga> getSpisakKnjiga(){
        return spisakKnjiga;
    }

    public void setSpisakKnjiga(Set<Knjiga> spisakKnjiga)
    {
        this.spisakKnjiga=spisakKnjiga;
    }


    public boolean isAktivan() {
        return aktivan;
    }


    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

}
