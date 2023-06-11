package com.tim22.web.service;

import com.tim22.web.dto.ZanrDto;
import com.tim22.web.entity.Zanr;
import com.tim22.web.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZanrService {
    @Autowired
    private ZanrRepository zanrRepository;

    public void save(ZanrDto zanrDto)
    {
        Zanr zanr=new Zanr();
        zanr.setNaziv(zanrDto.getNaziv());
    }
}
