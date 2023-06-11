package com.tim22.web.service;

import com.tim22.web.repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;
}
