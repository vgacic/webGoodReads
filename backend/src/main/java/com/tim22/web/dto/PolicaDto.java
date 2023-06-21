package com.tim22.web.dto;

import com.tim22.web.entity.Polica;

public class PolicaDto {
    private Long id;
    private String naziv;
    private boolean primarna;

    public PolicaDto(Long id, String naziv,boolean primarna) {
        this.id = id;
        this.naziv = naziv;
        this.primarna=primarna;
    }

    public PolicaDto() {
    }

    public PolicaDto(Polica polica) {
        this.id = polica.getId();
        this.naziv = polica.getNaziv();
        this.primarna=polica.getPrimarna();
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

    public boolean getPrimarna() {
        return primarna;
    }

    public void setPrimarna(boolean primarna) {
        this.primarna = primarna;
    }
}

