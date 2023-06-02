package com.tim22.web.service;

import com.tim22.web.entity.Korisnik;
import com.tim22.web.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
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

    public Korisnik login(String email,String lozinka)
    {
        List<Korisnik> korisnici= korisnikRepository.findAll();
        for(Korisnik korisnik : korisnici) {
           if(korisnik.getPassword().equals(lozinka)&&korisnik.getMail().equals(email))
               return korisnik;

        }
        return null;
    }
   /* public Korisnik register(String ime, String prezime, String username, String password, String email, String profilnaSlika, Date datumRodjenja)
    {

        return null;
    }*/

}
