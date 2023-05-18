package com.tim22.web.service;

import com.tim22.web.entity.Korisnik;
import com.tim22.web.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;


    public Korisnik findOne(Long id){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if (foundKorisnik.isPresent())
            return foundKorisnik.get();

        return null;
    }

    public List<Korisnik> findAll(){return korisnikRepository.findAll();}
    public Korisnik save(Korisnik korisnik){return korisnikRepository.save(korisnik);}

    public Korisnik login(String username,String password)
    {
        Korisnik korisnik = korisnikRepository.getByUsername(username);
        if((korisnik==null) || !korisnik.getPassword().equals(password)) return null;
        return korisnik;
    }
   /* public Korisnik register(String ime, String prezime, String username, String password, String email, String profilnaSlika, Date datumRodjenja)
    {

        return null;
    }*/

}
