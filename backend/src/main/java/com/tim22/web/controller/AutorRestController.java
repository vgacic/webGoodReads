package com.tim22.web.controller;

import com.tim22.web.dto.AzuriranAutorDto;
import com.tim22.web.dto.KnjigaDto;
import com.tim22.web.dto.ZahtevZaAktivacijuNalogaAutoraDto;
import com.tim22.web.entity.Autor;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.Korisnik;
import com.tim22.web.repository.AutorRepository;
import com.tim22.web.service.AutorService;
import com.tim22.web.service.KnjigaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;



@RestController
public class AutorRestController {
    @Autowired
    private AutorService autorService;
    @Autowired
    private KnjigaService knjigaService;




    @PostMapping("/api/dodajAutora")
    public ResponseEntity<?> dodajAutora(@RequestBody ZahtevZaAktivacijuNalogaAutoraDto zahtevZaAktivacijuNalogaAutoraDto, HttpSession session)
    {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        Long userId = null;
        if(loggedKorisnik ==null)
        {
            return new ResponseEntity<>("Nema sesije,uloguj se!",HttpStatus.UNAUTHORIZED);
        }
        else {
            userId=loggedKorisnik.getId();
        }

        if(loggedKorisnik.getUloga().equals(Korisnik.Uloga.ADMINISTRATOR))
        {
            Autor autor=new Autor();
            autor.setAktivan(false);
            autor.setEmail(zahtevZaAktivacijuNalogaAutoraDto.getEmail());
            autor.setUloga(Korisnik.Uloga.AUTOR);//mozda???
            autorService.save(autor);
            return ResponseEntity.ok("Autor kreiran");

        }
        return ResponseEntity.badRequest().body("Nisi administrator, ne mozes dodati autora");
    }

    @PutMapping("/api/azurirajAutora")
    public ResponseEntity<?> azurirajAutora(@RequestBody AzuriranAutorDto autor, HttpSession session)
    {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        Long userId=null;
        if(korisnik==null)
        {
            return new ResponseEntity<>("Nema sesije,uloguj se!",HttpStatus.UNAUTHORIZED);
        }
        else{
            userId=korisnik.getId();
        }
        if(korisnik.getUloga().equals(Korisnik.Uloga.AUTOR)|| korisnik.getUloga().equals(Korisnik.Uloga.ADMINISTRATOR))
        {
            autorService.azuriraj(autor,userId);
            return ResponseEntity.ok("Autor je azuriran");

        }
        return ResponseEntity.badRequest().body("Greska!Nisi autor ni administrator.Ne mozes azurirati autora.");
    }

    @DeleteMapping("/api/obrisiKnjigu")
    public ResponseEntity<?> obrisiSvojeKnjige(@RequestParam Long knjigaId,HttpSession session)
    {
        Korisnik loggedKorisnik=(Korisnik) session.getAttribute("korisnik");

        Long userId= loggedKorisnik.getId();

        if(loggedKorisnik==null)
        {
            return new ResponseEntity<>("Nema sesije.Uloguj se!",HttpStatus.UNAUTHORIZED);
        }
        else {
            userId=loggedKorisnik.getId();
        }
        Knjiga knjiga =knjigaService.getKnjigaById(knjigaId);

        if(!loggedKorisnik.getUloga().equals(Korisnik.Uloga.AUTOR) && !loggedKorisnik.getUloga().equals(Korisnik.Uloga.ADMINISTRATOR))
        {
            return new ResponseEntity<>("Nemas odobrenje,samo autor i admin mogu brisati knjigu!",HttpStatus.BAD_REQUEST);
        }
        if(loggedKorisnik.getUloga().equals(Korisnik.Uloga.AUTOR))
        {
            System.out.println("bla bla");
            Autor autor = autorService.findOne(userId);
            Set<Knjiga> autoroveKnjige=autor.getSpisakKnjiga();
            if(autoroveKnjige.contains(knjiga))
            {
                autoroveKnjige.remove(knjiga);
                knjigaService.obrisiIzBaze(knjigaId);
                return  ResponseEntity.ok("Obrisana knjiga iz if-a");
            }
        }
        knjigaService.obrisiIzBaze(knjigaId);
        return ResponseEntity.ok("Obrisana knjiga");
    }
}