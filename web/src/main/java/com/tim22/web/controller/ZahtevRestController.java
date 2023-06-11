package com.tim22.web.controller;

import com.tim22.web.dto.KnjigaDto;
import com.tim22.web.dto.ZahtevZaAktivacijuNalogaAutoraDto;
import com.tim22.web.entity.Knjiga;
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
    public ResponseEntity<List<ZahtevZaAktivacijuNalogaAutoraDto>> findAll() {
        List<ZahtevZaAktivacijuNalogaAutora> zahtevi = zahtevService.findAll();
        List<ZahtevZaAktivacijuNalogaAutoraDto> dtos = new ArrayList<>();

        for (ZahtevZaAktivacijuNalogaAutora zahtev : zahtevi)
            dtos.add(new ZahtevZaAktivacijuNalogaAutoraDto(zahtev));

        return ResponseEntity.ok(dtos);
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

        zahtevService.save(zahtevZaAktivacijuNalogaAutoraDto);
        return ResponseEntity.ok("Dodat zahtev");
    }

    @DeleteMapping("api/zahtev/{id}")
    public ResponseEntity<String> obrisi(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        ZahtevZaAktivacijuNalogaAutora zahtev = zahtevService.findById(id);

        if (zahtev == null) {
            return new ResponseEntity<>("Nepostoji zahtev", HttpStatus.BAD_REQUEST);
        }

        zahtevService.delete(id);
        return ResponseEntity.ok("Obrisana");
    }
}
