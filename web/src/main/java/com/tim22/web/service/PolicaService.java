package com.tim22.web.service;

import com.tim22.web.dto.PolicaDto;
import com.tim22.web.entity.Polica;
import com.tim22.web.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;

    public void save(PolicaDto policaDto){
        Polica polica=new Polica();
        polica.setNaziv(policaDto.getNaziv());
    }
}
