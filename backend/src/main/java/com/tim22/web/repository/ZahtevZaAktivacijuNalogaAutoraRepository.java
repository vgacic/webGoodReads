package com.tim22.web.repository;

import com.tim22.web.entity.ZahtevZaAktivacijuNalogaAutora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahtevZaAktivacijuNalogaAutoraRepository extends JpaRepository<ZahtevZaAktivacijuNalogaAutora, Long> {
}
