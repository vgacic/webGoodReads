package com.tim22.web.repository;


import com.tim22.web.entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZanrRepository extends JpaRepository<Zanr, Long> {
}
