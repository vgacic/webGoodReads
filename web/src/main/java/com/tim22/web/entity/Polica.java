package com.tim22.web.entity;

public class Polica {
    private String naziv;

    //oznaka da li je primarna - tip boolean??

    private boolean primarna;

    //polje stavka police ???? iz klase  StavkaPolice objekat ovde dodati


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isPrimarna() {
        return primarna;
    }

    public void setPrimarna(boolean primarna) {
        this.primarna = primarna;
    }
}
