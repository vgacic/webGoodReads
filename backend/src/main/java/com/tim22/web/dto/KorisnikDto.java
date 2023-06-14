package com.tim22.web.dto;


import com.tim22.web.entity.Korisnik;

import java.util.Date;

public class KorisnikDto {
        private String ime;
        private String prezime;

        private Date datumRodjenja;

    public KorisnikDto(String ime, String prezime, Date datumRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    public KorisnikDto(Korisnik korisnik) {

            ime=korisnik.getIme();
            prezime=korisnik.getPrezime();
            datumRodjenja=korisnik.getDatumRodjenja();
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

    }

