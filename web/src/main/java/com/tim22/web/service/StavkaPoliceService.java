package com.tim22.web.service;

import com.tim22.web.repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StavkaPoliceService {
    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;
}
