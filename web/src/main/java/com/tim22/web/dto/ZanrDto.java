package com.tim22.web.dto;

import com.tim22.web.entity.Zanr;

public class ZanrDto {
    private Long id;
    private String naziv;

    public ZanrDto(Zanr zanr)
    {
        this.id=zanr.getId();
        this.naziv=zanr.getNaziv();
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
};

