package com.tim22.web.dto;

import java.util.Date;

public class AzuriranaKnjigaDto {
    private String naslov;
    private String naslovnaFotografija;
    private String ISBN;
    private Date datumObjavljicanja;
    private int brojStrana;
    private String opis;
    private Long zanrId;

    public AzuriranaKnjigaDto(String naslov, String naslovnaFotografija, String ISBN, Date datumObjavljicanja, int brojStrana, String opis, Long zanrId) {
        this.naslov = naslov;
        this.naslovnaFotografija = naslovnaFotografija;
        this.ISBN = ISBN;
        this.datumObjavljicanja = datumObjavljicanja;
        this.brojStrana = brojStrana;
        this.opis = opis;
        this.zanrId = zanrId;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        this.naslovnaFotografija = naslovnaFotografija;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDatumObjavljicanja() {
        return datumObjavljicanja;
    }

    public void setDatumObjavljicanja(Date datumObjavljicanja) {
        this.datumObjavljicanja = datumObjavljicanja;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getZanrId() {
        return zanrId;
    }

    public void setZanrId(Long zanrId) {
        this.zanrId = zanrId;
    }
}
