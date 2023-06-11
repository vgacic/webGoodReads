package com.tim22.web.dto;

import com.tim22.web.entity.Recenzija;

public class RecenzijaDto {
    private Long id;
    private int ocena;
    private String tekst;

    public RecenzijaDto(Recenzija recenzija) {
        this.id = recenzija.getId();
        this.ocena = recenzija.getOcena();
        this.tekst = recenzija.getTekst();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
