package com.tim22.web.controller;

import com.tim22.web.dto.PolicaDto;
import com.tim22.web.dto.RecenzijaDto;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Polica;
import com.tim22.web.entity.Recenzija;
import com.tim22.web.entity.StavkaPolice;
import com.tim22.web.service.RecenzijaService;
import com.tim22.web.service.StavkaPoliceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
public class RecenzijaRestController {
    @Autowired
    private RecenzijaService recenzijaService;
    @Autowired
    private StavkaPoliceService stavkaPoliceService;

    @GetMapping("api/recenzije")
    public ResponseEntity<List<RecenzijaDto>> findAll() {
        List<Recenzija> recenzije = recenzijaService.findAll();
        List<RecenzijaDto> dtos = new ArrayList<>();

        for (Recenzija recenzija : recenzije)
            dtos.add(new RecenzijaDto(recenzija));

        return ResponseEntity.ok(dtos);
    }
    @GetMapping("api/recenzija/{id}")
    public ResponseEntity<RecenzijaDto> jedna(@PathVariable Long id) {
        Recenzija recenzija = recenzijaService.findById(id);
        if (recenzija == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(new RecenzijaDto(recenzija));

    }


    @PostMapping("api/recenzija")
    public ResponseEntity<String> dodaj(@RequestBody RecenzijaDto recenzijaDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        recenzijaService.save(recenzijaDto);
        return ResponseEntity.ok("Dodana recenzija");
    }

    @DeleteMapping("api/recenzija/{id}")
    public ResponseEntity<String> obrisi(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.BAD_REQUEST);
        }

        Recenzija recenzija = recenzijaService.findById(id);

        if (recenzija == null) {
            return new ResponseEntity<>("Nepostoji recenzija", HttpStatus.BAD_REQUEST);
        }

        recenzijaService.delete(id);
        return ResponseEntity.ok("Obrisana");
    }

    @GetMapping("api/recenzije-knjige/{id}")
    public ResponseEntity<List<RecenzijaDto>> recenzijeKnjige(@PathVariable Long id) {
        List<RecenzijaDto> recenzije = new ArrayList<>();
        for (StavkaPolice stavkaPolice : stavkaPoliceService.findAllByKnjigaId(id))
            for (Recenzija recenzija : stavkaPolice.getRecenzije())
                if (recenzija != null)
                    recenzije.add(new RecenzijaDto(recenzija));

        return ResponseEntity.ok(recenzije);
    }
}
