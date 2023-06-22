package com.tim22.web.controller;

import com.tim22.web.dto.KnjigaDto;
import com.tim22.web.dto.ZanrDto;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Zanr;
import com.tim22.web.service.ZanrService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ZanrRestController {
    @Autowired
    private ZanrService zanrService;

    @GetMapping("api/zanrovi")
    public ResponseEntity<List<ZanrDto>> findAll() {
        List<Zanr> zanrovi = zanrService.findAll();
        List<ZanrDto> dtos = new ArrayList<>();

        for (Zanr zanr: zanrovi)
            dtos.add(new ZanrDto(zanr));

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("api/zanr/{id}")
    public ResponseEntity<ZanrDto> jedna(@PathVariable Long id) {
        Zanr zanr = zanrService.findById(id);
        if (zanr == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ZanrDto(zanr));
    }
    @PostMapping("api/zanr")
    public ResponseEntity<String> dodaj(@RequestBody ZanrDto zanrDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        if (zanrService.findByNaziv(zanrDto.getNaziv()) != null) {
            return new ResponseEntity<>("Vec postoji zanr", HttpStatus.BAD_REQUEST);
        }

        zanrService.save(zanrDto);
        return ResponseEntity.ok("Dodat zanr");
    }

    @DeleteMapping("api/zanr/{id}")
    public ResponseEntity<String> obrisi(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        Zanr zanr = zanrService.findById(id);

        if (zanr == null) {
            return new ResponseEntity<>("Nepostoji zanr", HttpStatus.BAD_REQUEST);
        }

        zanrService.delete(id);
        return ResponseEntity.ok("Obrisan");
    }


}
