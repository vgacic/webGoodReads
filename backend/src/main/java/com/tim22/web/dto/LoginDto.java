package com.tim22.web.dto;

public class LoginDto {

    private String email;
    private String lozinka;

    // private String korisnickoIme;

    public LoginDto(String korisnickoIme, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
        // this.korisnickoIme=korisnickoIme;
    }


   /* public String getKorisnickoIme() {
        return korisnickoIme;
    }*/

  /*  public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
*/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
