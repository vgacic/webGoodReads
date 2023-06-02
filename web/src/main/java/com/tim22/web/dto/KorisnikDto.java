package com.tim22.web.dto;


import com.tim22.web.entity.Korisnik;

import java.util.Date;

public class KorisnikDto {
        private String ime;
        private String prezime;

        private Date datumRodjenja;

        public KorisnikDto() {
            this.ime = ime;
            this.prezime = prezime;

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

