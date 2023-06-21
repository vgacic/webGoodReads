package com.tim22.web.service;

import com.tim22.web.dto.RegisterDto;
import com.tim22.web.entity.Autor;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Polica;
import com.tim22.web.repository.AutorRepository;
import com.tim22.web.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private KnjigaService knjigaService;


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
            if(korisnik.getPassword().equals(lozinka)&&korisnik.getEmail().equals(email))
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

    public void aktivirajAutora(Autor autor, String email, String lozinka) {
        autor.setEmail(email);
        autor.setLozinka(lozinka);
        autor.setAktivan(true);
        autorRepository.save(autor);
    }

    public void delete(Long id) {
        Korisnik korisnik = findOne(id);

        if (korisnik.getUloga().equals(Korisnik.Uloga.AUTOR)&&!((Autor)korisnik).getSpisakKnjiga().isEmpty()){
            return;
        }

        korisnikRepository.delete(korisnik);
    }

    public boolean dodajPolicu(Long userId, Polica polica) {
        Optional<Korisnik>korisnik=korisnikRepository.findById(userId);
        if(!korisnik.isPresent()){
            return false;
        }
        Korisnik korisnik1=korisnik.get();
        Set<Polica>police=korisnik1.getPolice();
        police.add(polica);
        return true;
    }

    public Korisnik findById(Long korisnikId) { //NADJI KAKO IDE
        Korisnik korisnik=new Korisnik();
        return korisnik;
    }

    public boolean existsMail(String email) {
        return false;
    }

    public boolean existsKorisnickoIme(String korisnickoIme) {
        return false;
    }

    public void create(RegisterDto registerDto) {
    }

    public Korisnik findBykorisnickoIme(String korisnickoIme) {
        return this.korisnikRepository.findBykorisnickoIme(korisnickoIme);
    }
}
