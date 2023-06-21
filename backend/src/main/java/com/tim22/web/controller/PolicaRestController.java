package com.tim22.web.controller;

import com.tim22.web.dto.KnjigaDto;
import com.tim22.web.dto.PolicaDto;
import com.tim22.web.dto.RegisterDto;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Polica;
import com.tim22.web.service.KnjigaService;
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

    @GetMapping("api/ispisi_police")
    public ResponseEntity<List<PolicaDto>> findAll() {
        List<Polica> police = policaService.findAll();
        List<PolicaDto> dtos = new ArrayList<>();

        for (Polica polica : police)
            dtos.add(new PolicaDto(polica));

        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/api/polica/{id}")
    public ResponseEntity<PolicaDto> jedna(@PathVariable Long id) {
        Polica polica = policaService.findById(id);
        if (polica == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(new PolicaDto(polica));

    }


    @PostMapping("api/dodajPolicu") //ne radi
    public ResponseEntity<String> dodajPolice(@RequestBody PolicaDto policaDto, HttpSession session) {
        Korisnik loggedKorisnik=(Korisnik) session.getAttribute("korisnik");
        Long userId=loggedKorisnik.getId();

        if(loggedKorisnik==null)
        {
            return new ResponseEntity<>("Nema sesije, uloguj se.",HttpStatus.UNAUTHORIZED);
        }
        else {
            userId=loggedKorisnik.getId();
        }
        Polica polica=null;

        polica=policaService.napraviPolicu(policaDto);
        policaService.savePolica(polica);
        boolean daLi=korisnikService.dodajPolicu(userId,polica);
        if(!daLi)
        {
            return new ResponseEntity<>("vec postoji polica sa ovim nazivom!",HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Polica je dodata.");
    }

    @DeleteMapping("api/obrisiPolicu/{id}") //ne radi
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


    @GetMapping("/api/getPolice/{korisnikId}") //server eror
    public ResponseEntity<List<PolicaDto>> getKorisnikovePolice(HttpSession session,@PathVariable Long korisnikId)
    {
        Korisnik k =korisnikService.findById(korisnikId);
        Set<Polica> policeList=policaService.findByKorisnik(k);
        List<PolicaDto> dtos=new ArrayList<>();
        for(Polica polica:policeList)
        {
            PolicaDto dto=new PolicaDto(polica);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/api/citalac/polica/{policaId}/knjiga/{knjigaId}") //ne radi
    public ResponseEntity<String> deleteKnjigaCitalac(@PathVariable Long policaId, @PathVariable Long knjigaId, HttpSession session)
    {
        Korisnik loggedKorisnik=(Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik.getUloga().equals(Korisnik.Uloga.CITALAC))
        {
            KnjigaService.deleteKnjiga(loggedKorisnik.getId(),policaId,knjigaId);
            return  new ResponseEntity<>("Knjiga uspesno obrisana.",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Nisi administrator ne mozes obrisati knjigu od citaoca.",HttpStatus.FORBIDDEN); //u ovo udje
        }
    }

}
