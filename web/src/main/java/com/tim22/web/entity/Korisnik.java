package com.tim22.web.entity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
@Table(name="Korisnik")
@Inheritance(strategy = InheritanceType.JOINED)
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column
    protected String ime;
    @Column
    protected String prezime;

    @Column(unique = true)
    protected String korisnickoIme;
    @Column(unique = true)
    protected String email;
    @Column
    protected String lozinka;

    @Column
    protected Date datumRodjenja;

    @Column
    protected String profilnaSlika; //string zbog putanje do slike?

    @Column
    protected String opis;

    @Column
    protected String uloga; //citalac, autor, administraror

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id")
    protected Set<Polica> police = new HashSet<>();


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getProfilnaSlika() {
        return profilnaSlika;
    }

    public void setProfilnaSlika(String profilnaSlika) {
        this.profilnaSlika = profilnaSlika;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }


    public String getPassword() {
        return lozinka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Polica> getPolice() {
        return police;
    }

    public void setPolice(Set<Polica> police) {
        this.police = police;
    }
}
