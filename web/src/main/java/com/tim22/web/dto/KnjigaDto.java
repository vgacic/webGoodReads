package com.tim22.web.dto;

import com.tim22.web.entity.Knjiga;

import java.util.Date;

public class KnjigaDto {
    private Long id;
    private String naslov;
    private Date datum;

    private String ISBN;

    public KnjigaDto(Long id, String naslov, Date datum, String ISBN) {
        this.id = id;
        this.naslov = naslov;
        this.datum = datum;
        this.ISBN = ISBN;
    }

    public KnjigaDto(Knjiga knjiga) {
        this.id=knjiga.getId();
        this.naslov=knjiga.getNaslov();
        this.datum=knjiga.getDatumObjavljivanja();
        this.ISBN= knjiga.getISBN();;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}

