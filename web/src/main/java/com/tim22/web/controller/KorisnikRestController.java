package com.tim22.web.controller;

import com.tim22.web.dto.KorisnikDto;
import com.tim22.web.dto.LoginDto;
import com.tim22.web.dto.PolicaDto;
import com.tim22.web.dto.RegisterDto;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.entity.Polica;
import com.tim22.web.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KorisnikRestController {
    @Autowired
   private KorisnikService korisnikService;

    @PostMapping("api/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (!registerDto.getLozinka().equals(registerDto.getPonovljenaLozinka()))
            return new ResponseEntity<>("Nije dobra lozinka", HttpStatus.BAD_REQUEST);
        korisnikService.register(registerDto);
        return ResponseEntity.ok("Registrovan");
    }
    @PostMapping("api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session)
    {
        if(loginDto.getEmail().isEmpty() || loginDto.getLozinka().isEmpty())
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);
        Korisnik loggedKorisnik=korisnikService.login(loginDto.getEmail(), loginDto.getLozinka());
        if(loggedKorisnik==null){
            return new ResponseEntity<>("User does not exist!", HttpStatus.NOT_FOUND);
        }
        session.setAttribute("korisnik", loggedKorisnik);
        return ResponseEntity.ok("Successfully logged in!");
    }

    @PostMapping("api/logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik loggedEmployee = (Korisnik) session.getAttribute("korisnik");

        if (loggedEmployee == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);
    }


    @GetMapping("/api/korisnik")
    public ResponseEntity<Korisnik> getKorisnik(@RequestParam Long id){

        Korisnik korisnik = korisnikService.findOne(id);
        if(korisnik!=null)
        {
            return  ResponseEntity.ok(korisnik);
        }
        return new ResponseEntity("Nije nadjen korisnik", HttpStatus.NOT_FOUND);

    }


    @GetMapping("/api/korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session){
        List<Korisnik> korisnikList = korisnikService.findAll();

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null) {
            System.out.println("Nema sesije");
        } else {
            System.out.println(loggedKorisnik.getIme());
        }

        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik korisnik : korisnikList){ //korisnik->dto da ne bi sslali sve podatke
            KorisnikDto dto = new KorisnikDto(korisnik);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("api/korisnik/{id}")
    public ResponseEntity<String> obrisi(@PathVariable(required = false) Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.FORBIDDEN);
        }

        // Korisnik brise sam sebe
        if (id == null && !korisnik.getUloga().equals("administrator")) {
            korisnikService.delete(korisnik.getId());
            return ResponseEntity.ok("Obrisan korisnik");
        } else if (id != null && korisnik.getUloga().equals("administrator")) {
            korisnikService.delete(id);
            // Autor ne moze da se obrise ako ima knjiga ali se i dalje ispise ovo
            return ResponseEntity.ok("Obrisan korisnik, mozda?");
        } else {
            return new ResponseEntity<>("Ne mozete a brisete druge korisnike", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("api/police-prijavljenog")
    public ResponseEntity<List<PolicaDto>> policePrijavljenog(HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        List<PolicaDto> police = new ArrayList<>();
        for (Polica polica : korisnik.getPolice()) {
            police.add(new PolicaDto(polica));
        }

        return ResponseEntity.ok(police);
    }
}
