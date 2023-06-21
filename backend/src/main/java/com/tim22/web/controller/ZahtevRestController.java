package com.tim22.web.controller;

import com.tim22.web.dto.ZahtevZaAktivacijuNalogaAutoraDto;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Status;
import com.tim22.web.entity.ZahtevZaAktivacijuNalogaAutora;
import com.tim22.web.service.ZahtevService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZahtevRestController {
    @Autowired
    private ZahtevService zahtevService;

    @GetMapping("api/zahtevi")
    ResponseEntity<?> listaZahteva(HttpSession session)
    {
        Korisnik korisnik=(Korisnik) session.getAttribute("korisnik");
        if(korisnik==null)
        {
            return ResponseEntity.badRequest().build();
        }
        if(korisnik.getUloga().equals(Korisnik.Uloga.ADMINISTRATOR))
        {
            List<ZahtevZaAktivacijuNalogaAutora> sviZahtevi = zahtevService.findAll();
            List<ZahtevZaAktivacijuNalogaAutoraDto> trazeni=new ArrayList<ZahtevZaAktivacijuNalogaAutoraDto>();

            for(ZahtevZaAktivacijuNalogaAutora z:sviZahtevi)
            {
                if(z.getStanje()==Status.NA_CEKANJU)
                {
                    ZahtevZaAktivacijuNalogaAutoraDto zahtev=new ZahtevZaAktivacijuNalogaAutoraDto(z.getEmail(),z.getTelefon(),z.getPoruka(),z.getStanje());
                    trazeni.add(zahtev);
                }
            }
            return ResponseEntity.ok(trazeni);
        }
        return ResponseEntity.badRequest().body("Nisi admin, ne mozes videti zahteve.");
    }

    @GetMapping("api/zahtev/{id}")
    public ResponseEntity<ZahtevZaAktivacijuNalogaAutoraDto> jedna(@PathVariable Long id) {
        ZahtevZaAktivacijuNalogaAutora zahtev = zahtevService.findById(id);
        if (zahtev == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ZahtevZaAktivacijuNalogaAutoraDto(zahtev));
    }

    @PostMapping("api/zahtev")
    public ResponseEntity<String> dodaj(@RequestBody ZahtevZaAktivacijuNalogaAutoraDto zahtevZaAktivacijuNalogaAutoraDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }
        ZahtevZaAktivacijuNalogaAutora zahtevZaAktivacijuNalogaAutora=new ZahtevZaAktivacijuNalogaAutora(zahtevZaAktivacijuNalogaAutoraDto.getDatum(),
                zahtevZaAktivacijuNalogaAutoraDto.getEmail(),
                zahtevZaAktivacijuNalogaAutoraDto.getPoruka(),
                zahtevZaAktivacijuNalogaAutoraDto.getTelefon(),
                zahtevZaAktivacijuNalogaAutoraDto.getAutor(),
                zahtevZaAktivacijuNalogaAutoraDto.getStanje());
        zahtevService.saveZahtev(zahtevZaAktivacijuNalogaAutora);
        return ResponseEntity.ok("Dodat zahtev");
    }



    @PutMapping("api/obradi_zahtev/{id}")//jel mi treba ovo?
    public ResponseEntity<String> obradi(@PathVariable Long id, @RequestParam Boolean prihvati, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.FORBIDDEN);
        }

        if (!korisnik.getUloga().equals("administrator")) {
            return new ResponseEntity<>("Niste administrator", HttpStatus.FORBIDDEN);
        }

        if (!zahtevService.findById(id).getStanje().equals(Status.NA_CEKANJU)) {
            return new ResponseEntity<>("Vec je obradjen zahtev", HttpStatus.BAD_REQUEST);
        }

        zahtevService.obradi(id, prihvati);

        return ResponseEntity.ok("Obradjen zahtev");
    }


    @PostMapping("/api/zahtev/posalji")
    ResponseEntity<String> posaljiZahtev(@RequestBody ZahtevZaAktivacijuNalogaAutoraDto zahtevDto)
    {
        ZahtevZaAktivacijuNalogaAutora zahtev= new ZahtevZaAktivacijuNalogaAutora();
        zahtev.setEmail(zahtevDto.getEmail());
        zahtev.setTelefon(zahtevDto.getTelefon());
        zahtev.setPoruka(zahtevDto.getPoruka());
        zahtev.setStanje(Status.NA_CEKANJU);
        return ResponseEntity.ok("Zahtev je poslat");
    }


    @PutMapping("/api/zahtev/prihvati/{id}")
    public ResponseEntity<String> prihvatiZahtev(@PathVariable(name = "id")Long zahtevId,HttpSession session)
    {
        Korisnik loggedKorisnik=(Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik.getUloga()==Korisnik.Uloga.ADMINISTRATOR)
        {
            ZahtevZaAktivacijuNalogaAutora zahtev=zahtevService.findById(zahtevId);

            zahtev.setStanje(Status.ODOBREN);
            zahtevService.saveZahtev(zahtev);

        }
        return ResponseEntity.ok("Prihvacen zahtev");
    }
}
