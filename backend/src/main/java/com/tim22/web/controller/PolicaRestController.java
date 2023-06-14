package com.tim22.web.controller;

import com.tim22.web.dto.KnjigaDto;
import com.tim22.web.dto.PolicaDto;
import com.tim22.web.dto.RegisterDto;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Polica;
import com.tim22.web.service.KorisnikService;
import com.tim22.web.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class PolicaRestController {
    @Autowired
    private PolicaService policaService;
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("api/police")
    public ResponseEntity<List<PolicaDto>> findAll() {
        List<Polica> police = policaService.findAll();
        List<PolicaDto> dtos = new ArrayList<>();

        for (Polica polica : police)
            dtos.add(new PolicaDto(polica));

        return ResponseEntity.ok(dtos);
    }
    @GetMapping("api/polica/{id}")
    public ResponseEntity<PolicaDto> jedna(@PathVariable Long id) {
        Polica polica = policaService.findById(id);
        if (polica == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(new PolicaDto(polica));

    }


    @PostMapping("api/polica")
    public ResponseEntity<String> dodaj(@RequestBody PolicaDto policaDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        Polica polica = policaService.save(policaDto);
        korisnik = korisnikService.findOne(korisnik.getId());
        Set<Polica> police = korisnik.getPolice();
        police.add(polica);
        korisnik.setPolice(police);
        korisnikService.save(korisnik);
        return ResponseEntity.ok("Dodana polica");
    }

    @DeleteMapping("api/polica/{id}")
    public ResponseEntity<String> obrisi(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        Polica polica = policaService.findById(id);

        if (polica == null) {
            return new ResponseEntity<>("Nepostoji polica", HttpStatus.BAD_REQUEST);
        }

        policaService.delete(id);
        return ResponseEntity.ok("Obrisana");
    }

}
