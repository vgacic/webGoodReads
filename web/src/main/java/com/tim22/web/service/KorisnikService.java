package com.tim22.web.service;

import com.tim22.web.dto.RegisterDto;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Polica;
import com.tim22.web.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Korisnik register(RegisterDto registerDto)
    {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(registerDto.getIme());
        korisnik.setPrezime(registerDto.getPrezime());
        korisnik.setEmail(registerDto.getEmail());
        korisnik.setKorisnickoIme(registerDto.getKorisnickoIme());
        korisnik.setLozinka(registerDto.getLozinka());

        Set<Polica> police = new HashSet<>();
        Polica polica = new Polica();
        polica.setPrimarna(true);
        polica.setNaziv("Read");
        police.add(polica);
        polica = new Polica();
        polica.setPrimarna(true);
        polica.setNaziv("Want To Read");
        police.add(polica);
        polica = new Polica();
        polica.setPrimarna(true);
        polica.setNaziv("Currently Reading");
        police.add(polica);
        korisnik.setPolice(police);
        return korisnikRepository.save(korisnik);
    }

}
