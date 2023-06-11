package com.tim22.web.service;

import com.tim22.web.dto.ZahtevZaAktivacijuNalogaAutoraDto;
import com.tim22.web.entity.ZahtevZaAktivacijuNalogaAutora;
import com.tim22.web.repository.ZahtevZaAktivacijuNalogaAutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahtevService {
    @Autowired
    private ZahtevZaAktivacijuNalogaAutoraRepository zahtevRepository;

    public void save(ZahtevZaAktivacijuNalogaAutoraDto zahtevZaAktivacijuNalogaAutoraDto){
        ZahtevZaAktivacijuNalogaAutora zahtev=new ZahtevZaAktivacijuNalogaAutora();

        zahtev.setDatum(zahtevZaAktivacijuNalogaAutoraDto.getDatum());
        zahtev.setEmail(zahtevZaAktivacijuNalogaAutoraDto.getEmail());
        zahtev.setPoruka(zahtevZaAktivacijuNalogaAutoraDto.getPoruka());
        zahtev.setTelefon(zahtevZaAktivacijuNalogaAutoraDto.getTelefon());
    }
}
