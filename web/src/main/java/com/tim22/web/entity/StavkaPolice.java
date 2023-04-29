package com.tim22.web.entity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StavkaPolice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Polica polica;

    @OneToOne(mappedBy = "stavkaPolice")
    private Knjiga knjiga;

    @OneToMany(mappedBy = "stavkaPolice",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Recenzija> recenzije= new HashSet<>();


}
