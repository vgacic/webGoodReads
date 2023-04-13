package com.tim22.web.repository;

import com.tim22.web.entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
}
