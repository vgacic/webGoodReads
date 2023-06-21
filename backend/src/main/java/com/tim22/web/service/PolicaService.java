package com.tim22.web.service;

import com.tim22.web.dto.PolicaDto;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Polica;
import com.tim22.web.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;
    public Polica findById(Long id) {
        Optional<Polica> polica = policaRepository.findById(id);
        if (polica.isPresent())
            return polica.get();
        return null;
    }
    public List<Polica> findAll() {
        return policaRepository.findAll();
    }


    public Polica save(PolicaDto policaDto){
        Polica polica=new Polica();
        polica.setNaziv(policaDto.getNaziv());
        return policaRepository.save(polica);
    }
    public void delete(Long id) {
        policaRepository.deleteById(id);
    }

    public Polica napraviPolicu(PolicaDto policaDto) {
        Polica polica = new Polica(policaDto.getNaziv(),policaDto.getPrimarna());
        return polica;
    }

    public void savePolica(Polica polica) {
        this.policaRepository.save(polica);
    }

    public Set<Polica> findByKorisnik(Korisnik k) {
        return null;
    }
}
