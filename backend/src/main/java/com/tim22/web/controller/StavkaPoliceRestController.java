package com.tim22.web.controller;

import com.tim22.web.dto.StavkaPoliceDto;
import com.tim22.web.entity.Knjiga;
import com.tim22.web.entity.StavkaPolice;
import com.tim22.web.service.KnjigaService;
import com.tim22.web.service.StavkaPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
public class StavkaPoliceRestController {
    @Autowired
    private StavkaPoliceService stavkaPoliceService;

    @Autowired
    private KnjigaService knjigaService;


    @GetMapping("/api/stavkaPolice/{naslov}")
    public ResponseEntity<List<StavkaPoliceDto>> getKnjigaPoNaslovu(@PathVariable(name = "naslov")String naslov)
    {
        Knjiga k= knjigaService.getByName(naslov);
        if(k==null)
        {
            return ResponseEntity.notFound().build();
        }
        Long id=k.getId();
        List<StavkaPolice> sp=stavkaPoliceService.dobaviStavku(id);
        List<StavkaPoliceDto> dtos=new ArrayList<>();

        for(StavkaPolice s:sp)
        {
            StavkaPoliceDto dto=new StavkaPoliceDto(s);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }


}
