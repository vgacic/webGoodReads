package com.tim22.web.dto;

import com.tim22.web.entity.Polica;

public class PolicaDto {
    private Long id;
    private String naziv;

    public PolicaDto(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public PolicaDto(Polica polica) {
        this.id = polica.getId();
        this.naziv = polica.getNaziv();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}

