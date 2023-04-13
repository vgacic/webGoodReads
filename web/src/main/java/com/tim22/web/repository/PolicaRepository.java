package com.tim22.web.repository;


import com.tim22.web.entity.Polica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicaRepository extends JpaRepository<Polica, Long> {
}
