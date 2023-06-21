package com.tim22.web.service;

import com.tim22.web.dto.ZahtevZaAktivacijuNalogaAutoraDto;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.Status;
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
    @Autowired
    private KorisnikService korisnikService;

    public ZahtevZaAktivacijuNalogaAutora findById(Long id) {
        Optional<ZahtevZaAktivacijuNalogaAutora> zahtev = zahtevRepository.findById(id);
        if (zahtev.isPresent())
            return zahtev.get();
        return null;
    }
    public List<ZahtevZaAktivacijuNalogaAutora> findAll() {
        return zahtevRepository.findAll();
    }

    public ZahtevZaAktivacijuNalogaAutora saveZahtev(ZahtevZaAktivacijuNalogaAutora zahtevAktivacija) {return zahtevRepository.save(zahtevAktivacija);}

    public void obradi(Long id, Boolean prihvati) {
        ZahtevZaAktivacijuNalogaAutora zahtev = findById(id);
        if (prihvati) {
            zahtev.setStanje(Status.ODOBREN);
            korisnikService.aktivirajAutora(zahtev.getAutor(), zahtev.getEmail(), "lozinka");
        } else {
            zahtev.setStanje(Status.ODBIJEN);
        }

        zahtevRepository.save(zahtev);
    }

    public ZahtevZaAktivacijuNalogaAutora findOne(Long zahtevId) {
        return null;
    }
}
