package com.tim22.web.service;

import com.tim22.web.dto.AzuriranAutorDto;
import com.tim22.web.entity.Autor;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.repository.AutorRepository;
import com.tim22.web.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AutorService {


    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll()
    {
        return autorRepository.findAll();
    }

    public Autor findOne(Long id)
    {
        List<Autor> autori=findAll();
        for(Autor a:autori)
        {
            if(a.getId()==id)
            {
                return a;
            }
        }
        return null;
    }

    public Autor findByEmail(String mail){return autorRepository.findByEmail(mail);}

    public boolean sadrzi(Knjiga k, Autor autor)
    {
        Set<Knjiga>knjige=autor.getSpisakKnjiga();
        if(knjige.contains(k)){
            return true;
        }
        knjigaRepository.save(k);
        return false;
    }



    public Autor save(Autor autor) {
        return autorRepository.save(autor);

    }

    public void dodajKnjiguUListu(Knjiga k,Long id)
    {
        List<Autor> autori=autorRepository.findAll();

        for(Autor a:autori)
        {
            if(a.getId()==id)
            {
                a.getSpisakKnjiga().add(k);
                save(a);
            }
        }
    }

    public void azuriraj(AzuriranAutorDto a,Long id)
    {
        List<Autor> autori=findAll();
        for(Autor autor:autori)
        {
            if(autor.getId()==id)
            {
                autor.setIme(a.getIme());
                autor.setPrezime(a.getPrezime());
                autor.setKorisnickoIme(a.getKorisnickoIme());
                autor.setDatumRodjenja(a.getDatumRodjenja());
                autor.setProfilnaSlika(a.getProfilnaSlika());
                autor.setAktivan(true);
            }
        }
    }



}
