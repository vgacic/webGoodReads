package com.tim22.web.controller;

import com.tim22.web.dto.KnjigaDto;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.StavkaPolice;
import com.tim22.web.service.KnjigaService;
import com.tim22.web.service.StavkaPoliceService;
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

    @PostMapping("api/knjiga")
    public ResponseEntity<String> dodaj(@RequestBody KnjigaDto knjigaDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        knjigaService.save(knjigaDto);
        return ResponseEntity.ok("Dodana knjiga");
    }

    @DeleteMapping("api/knjiga/{id}")
    public ResponseEntity<String> obrisi(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        Knjiga knjiga = knjigaService.findById(id);

        if (knjiga == null) {
            return new ResponseEntity<>("Nepostoji knjiga", HttpStatus.BAD_REQUEST);
        }

        for (StavkaPolice stavkaPolice : stavkaPoliceService.findAllByKnjigaId(id))
            if (!stavkaPolice.getRecenzije().isEmpty())
                return new ResponseEntity<>("Ne moze se obrisati knjiga sa recenzijama", HttpStatus.BAD_REQUEST);

        knjigaService.delete(id);
        return ResponseEntity.ok("Obrisana");
    }

    @GetMapping("api/pretrazi")
    public ResponseEntity<List<KnjigaDto>> pretraga(@RequestParam String pretraga) {
        List<Knjiga> knjige = new ArrayList<>();
        knjige.addAll(knjigaService.findAllByNaslov(pretraga));
//        knjige.addAll(knjigaService.findAllByZanr(pretraga));

        List<KnjigaDto> dtos = new ArrayList<>();
        for (Knjiga knjiga : knjige)
            dtos.add(new KnjigaDto(knjiga));

        return ResponseEntity.ok(dtos);
    }
}
