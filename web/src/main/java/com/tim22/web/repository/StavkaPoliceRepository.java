package com.tim22.web.repository;


import com.tim22.web.entity.StavkaPolice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StavkaPoliceRepository extends JpaRepository<StavkaPolice, Long> {
    List<StavkaPolice> findAllByKnjigaId(Long knjigaId);
}
