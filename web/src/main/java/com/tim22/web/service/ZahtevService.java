package com.tim22.web.service;

import com.tim22.web.repository.ZahtevZaAktivacijuNalogaAutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahtevService {
    @Autowired
    private ZahtevZaAktivacijuNalogaAutoraRepository zahtevRepository;
}
