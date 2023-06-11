package com.tim22.web.service;

import com.tim22.web.dto.ZanrDto;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.Zanr;
import com.tim22.web.repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZanrService {
    @Autowired
    private ZanrRepository zanrRepository;

    public Zanr findById(Long id) {
        Optional<Zanr> zanr = zanrRepository.findById(id);
        if (zanr.isPresent())
            return zanr.get();
        return null;
    }
    public List<Zanr> findAll() {
        return zanrRepository.findAll();
    }

    public void save(ZanrDto zanrDto)
    {
        Zanr zanr=new Zanr();
        zanr.setNaziv(zanrDto.getNaziv());
        zanrRepository.save(zanr);
    }
    public void delete(Long id) {
        zanrRepository.deleteById(id);
    }

}
