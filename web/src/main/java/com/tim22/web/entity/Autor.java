package com.tim22.web.entity;

import java.util.ArrayList;

public class Autor extends Korisnik{
    private boolean aktivan;

    private ArrayList<String> SpisakKnjiga;

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public ArrayList<String> getSpisakKnjiga() {
        return SpisakKnjiga;
    }
}
