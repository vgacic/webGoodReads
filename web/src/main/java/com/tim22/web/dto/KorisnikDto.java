package com.tim22.web.dto;


import com.tim22.web.entity.Korisnik;

import java.util.Date;

public class KorisnikDto {
        private String ime;
        private String prezime;
        private String korisnickoIme;
        private String email;
        private String lozinka;

        private Date datumRodjenja;

        public KorisnikDto() {
            this.ime = ime;
            this.prezime = prezime;
            this.korisnickoIme = korisnickoIme;
            this.email = email;
        }

    public KorisnikDto(Korisnik korisnik) {

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email=email;
}
    }

