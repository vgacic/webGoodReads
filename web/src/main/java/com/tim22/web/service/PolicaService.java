package com.tim22.web.service;

import com.tim22.web.repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;
}
