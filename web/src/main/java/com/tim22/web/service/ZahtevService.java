package com.tim22.web.service;

import com.tim22.web.dto.ZahtevZaAktivacijuNalogaAutoraDto;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.ZahtevZaAktivacijuNalogaAutora;
import com.tim22.web.repository.ZahtevZaAktivacijuNalogaAutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZahtevService {
    @Autowired
    private ZahtevZaAktivacijuNalogaAutoraRepository zahtevRepository;
    public ZahtevZaAktivacijuNalogaAutora findById(Long id) {
        Optional<ZahtevZaAktivacijuNalogaAutora> zahtev = zahtevRepository.findById(id);
        if (zahtev.isPresent())
            return zahtev.get();
        return null;
    }
    public List<ZahtevZaAktivacijuNalogaAutora> findAll() {
        return zahtevRepository.findAll();
    }

    public void save(ZahtevZaAktivacijuNalogaAutoraDto zahtevZaAktivacijuNalogaAutoraDto){
        ZahtevZaAktivacijuNalogaAutora zahtev=new ZahtevZaAktivacijuNalogaAutora();

        zahtev.setDatum(zahtevZaAktivacijuNalogaAutoraDto.getDatum());
        zahtev.setEmail(zahtevZaAktivacijuNalogaAutoraDto.getEmail());
        zahtev.setPoruka(zahtevZaAktivacijuNalogaAutoraDto.getPoruka());
        zahtev.setTelefon(zahtevZaAktivacijuNalogaAutoraDto.getTelefon());
        zahtevRepository.save(zahtev);
    }
    public void delete(Long id) {
        zahtevRepository.deleteById(id);
    }

}
