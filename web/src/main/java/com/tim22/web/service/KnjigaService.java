package com.tim22.web.service;

import com.tim22.web.entity.Knjiga;
import com.tim22.web.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public Knjiga findById(Long id) {
        Optional<Knjiga> knjiga = knjigaRepository.findById(id);
        if (knjiga.isPresent())
            return knjiga.get();
        return null;
    }

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

    public void save(KnjigaDto knjigaDto) {
        Knjiga knjiga = new Knjiga();
        // napravi dto i postavi sve u knjizi iz dto
        // knjiga.setNaslov(knjigaDto.getNaslov());
        // ...
        knjigaRepository.save(knjiga);
    }

    public void delete(Long id) {
        knjigaRepository.deleteById(id);
    }
}
