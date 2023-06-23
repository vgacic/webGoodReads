package com.tim22.web.repository;

import com.tim22.web.entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
    //List<Knjiga> findAllByAutorId(Long autorId);
    List<Knjiga> findAllByNaslov(String naslov);
    List<Knjiga> findAllByZanr(String zanr);

    Knjiga findByNaslov(String naslov);
}
