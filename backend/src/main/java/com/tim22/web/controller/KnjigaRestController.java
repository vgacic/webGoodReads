package com.tim22.web.controller;

import com.tim22.web.dto.AzuriranaKnjigaDto;
import com.tim22.web.dto.KnjigaDto;
import com.tim22.web.entity.Autor;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.StavkaPolice;
import com.tim22.web.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KnjigaRestController {
    @Autowired
    private KnjigaService knjigaService;
    @Autowired
    private StavkaPoliceService stavkaPoliceService;
    @Autowired
    private PolicaService policaService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private AutorService autorService;



    @GetMapping("/api/knjiga/{zanrNaziv}")
    public ResponseEntity<List<KnjigaDto>> getKnjigaZanr(@PathVariable(name = "zanrNaziv")String zanr,HttpSession session)
    {
        List<Knjiga> knjige=knjigaService.findAll();
        List<KnjigaDto> trazene=new ArrayList<>();
        for(Knjiga k:knjige)
        {
            if(k.getZanr().getNaziv()==zanr)
            {
                KnjigaDto dto= new KnjigaDto(k);
                trazene.add(dto);
            }

        }
        return ResponseEntity.ok(trazene);
    }

    @GetMapping("api/knjige")
    public ResponseEntity<List<KnjigaDto>> findAll() {
        List<Knjiga> knjige = knjigaService.findAll();
        List<KnjigaDto> dtos = new ArrayList<>();

        for (Knjiga knjiga : knjige)
            dtos.add(new KnjigaDto(knjiga));

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("api/knjiga/{id}")
    public ResponseEntity<KnjigaDto> jedna(@PathVariable Long id) {
        Knjiga knjiga = knjigaService.findById(id);
        if (knjiga == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(new KnjigaDto(knjiga));
    }

    /*@PostMapping("api/knjiga")
    public ResponseEntity<String> dodaj(@RequestBody KnjigaDto knjigaDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        knjigaService.save(knjigaDto);
        return ResponseEntity.ok("Dodana knjiga");
    }*/

    @DeleteMapping("api/knjiga/{id}")
    public ResponseEntity<String> obrisi(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        Knjiga knjiga = knjigaService.findById(id);

        if (knjiga == null) {
            return new ResponseEntity<>("Ne postoji knjiga", HttpStatus.BAD_REQUEST);
        }

        for (StavkaPolice stavkaPolice : stavkaPoliceService.findAllByKnjigaId(id))
            if (!stavkaPolice.getRecenzije().isEmpty())
                return new ResponseEntity<>("Ne moze se obrisati knjiga sa recenzijama", HttpStatus.BAD_REQUEST);

        knjigaService.delete(id);
        return ResponseEntity.ok("Obrisana");
    }

    @GetMapping("api/pretrazi/{naslov}")
    public ResponseEntity<List<KnjigaDto>> pretraga(@RequestParam String pretraga) {
        List<Knjiga> knjige = new ArrayList<>();
        knjige.addAll(knjigaService.findAllByNaslov(pretraga));
//        knjige.addAll(knjigaService.findAllByZanr(pretraga));

        List<KnjigaDto> dtos = new ArrayList<>();
        for (Knjiga knjiga : knjige)
            dtos.add(new KnjigaDto(knjiga));

        return ResponseEntity.ok(dtos);
    }


    @PostMapping("/api/autor/dodajKnjige") //radi
    public ResponseEntity<String> napraviKnjigu(@RequestBody KnjigaDto knjigaDto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        Long userId = loggedKorisnik.getId();

        if (loggedKorisnik == null) {
            return new ResponseEntity<>("Nema sesije.Uloguj se.", HttpStatus.UNAUTHORIZED);
        }
        else {
            userId = loggedKorisnik.getId();
        }
        if (!loggedKorisnik.getUloga().equals(Korisnik.Uloga.AUTOR)) {
            return new ResponseEntity<>("Samo autor i admin mogu dodati knjigu!", HttpStatus.BAD_REQUEST);
        }

        Knjiga k=knjigaService.kreirajKnjigu(knjigaDto.getNaslov(),knjigaDto.getDatum(),knjigaDto.getISBN());
        boolean daLi=autorService.sadrzi(k,(Autor)loggedKorisnik);

        if(daLi)
        {
            return new ResponseEntity<>("Vec dodata knjiga.",HttpStatus.BAD_REQUEST);
        }
        autorService.dodajKnjiguUListu(k,userId);
        return  ResponseEntity.ok("Kreirana nova knjiga!");

    }

    @PutMapping("api/knjiga/{id}/update_knjiga")
    public ResponseEntity<?> updateKnjigaAdministrator(@RequestBody AzuriranaKnjigaDto azuriranaKnjigaDto, @PathVariable("id")Long knjigaId, HttpSession session)
    {
        Korisnik loggedKorisnik=(Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik.getUloga().equals(Korisnik.Uloga.ADMINISTRATOR) || loggedKorisnik.getUloga().equals(Korisnik.Uloga.AUTOR))
        {
            knjigaService.updateKnjigaAdmin(knjigaId,azuriranaKnjigaDto);
            return new ResponseEntity<>("knjiga azurirana",HttpStatus.OK);

        }
        else
        {
            return new ResponseEntity<>("Nisi admin",HttpStatus.BAD_REQUEST);
        }
    }



}
