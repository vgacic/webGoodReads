package com.tim22.web.service;

import com.tim22.web.dto.AzuriranaKnjigaDto;
import com.tim22.web.dto.KnjigaDto;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.StavkaPolice;
import com.tim22.web.repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private StavkaPoliceService stavkaPoliceService;


    public Knjiga findById(Long id) {
        Optional<Knjiga> knjiga = knjigaRepository.findById(id);
        if (knjiga.isPresent())
            return knjiga.get();
        return null;
    }

    public List<Knjiga> findAllByZanr(String zanr) {
        return knjigaRepository.findAllByZanr(zanr);
    }

    public List<Knjiga> findAllByNaslov(String naslov) {
        return knjigaRepository.findAllByNaslov(naslov);
    }

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

    //public List<Knjiga> findAllByAutorId(Long autorId) {
       // return knjigaRepository.findAllByAutorId(autorId);
    //}

    public void save(KnjigaDto knjigaDto) {
        Knjiga knjiga = new Knjiga();
        // napravi dto i postavi sve u knjizi iz dto
        knjiga.setNaslov(knjigaDto.getNaslov());
        knjiga.setDatumObjavljivanja(knjigaDto.getDatum());
        knjiga.setISBN(knjigaDto.getISBN());
        knjigaRepository.save(knjiga);
    }

    public void delete(Long id) {
        for (StavkaPolice stavkaPolice : stavkaPoliceService.findAllByKnjigaId(id))
            stavkaPoliceService.delete(stavkaPolice);
        knjigaRepository.deleteById(id);
    }

    public Knjiga getByName(String naslov) {
        Knjiga knjiga=new Knjiga();
        return knjiga;
    }

    public static void deleteKnjiga(Long id, Long policaId, Long knjigaId) {
    }

    public Knjiga getKnjigaById(Long knjigaId) {
        Knjiga knjiga=new Knjiga();
        return knjiga;
    }

    public void obrisiIzBaze(Long id) {
        knjigaRepository.deleteById(id);
    }

    public void updateKnjigaAdmin(Long knjigaId, AzuriranaKnjigaDto azuriranaKnjigaDto) {

    }

    public Knjiga kreirajKnjigu(String naslov, Date datum, String isbn) {
        Knjiga knjiga=new Knjiga(naslov,datum,isbn);
        return knjiga;
    }

    public Knjiga nadjiKnjiguPoNaslovu(String naslov) {
        Knjiga knjiga=knjigaRepository.findByNaslov(naslov);
        if(knjiga!=null)
        {
            return knjiga;
        }
        List<Knjiga> knjige=knjigaRepository.findAll();
        for(Knjiga k : knjige)
        {
            if(k.getNaslov().equalsIgnoreCase(naslov)){
                return k;
            }
            else if(k.getNaslov().contains(naslov))
            {
                return k;
            }
        }
        return null;
    }
}
