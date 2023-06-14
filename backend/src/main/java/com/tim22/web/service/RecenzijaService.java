package com.tim22.web.service;

import com.tim22.web.dto.RecenzijaDto;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.Recenzija;
import com.tim22.web.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;
    public Recenzija findById(Long id) {
        Optional<Recenzija> recenzija = recenzijaRepository.findById(id);
        if (recenzija.isPresent())
            return recenzija.get();
        return null;
    }
    public List<Recenzija> findAll() {
        return recenzijaRepository.findAll();
    }

    public void save(RecenzijaDto recenzijaDto){
        Recenzija recenzija=new Recenzija();
        recenzija.setOcena(recenzijaDto.getOcena());
        recenzija.setTekst(recenzijaDto.getTekst());
        recenzijaRepository.save(recenzija);
    }
    public void delete(Long id) {
        recenzijaRepository.deleteById(id);
    }

}
