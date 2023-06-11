package com.tim22.web.service;

import com.tim22.web.dto.RecenzijaDto;
import com.tim22.web.entity.Recenzija;
import com.tim22.web.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;

    public void save(RecenzijaDto recenzijaDto){
        Recenzija recenzija=new Recenzija();
        recenzija.setOcena(recenzijaDto.getOcena());
        recenzija.setTekst(recenzijaDto.getTekst());

    }
}
